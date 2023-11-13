class Node {
    int l;
    int r;
    int mid;
    int v;
    Node left;
    Node right;

    public Node(int l, int r) {
        this.l = l;
        this.r = r;
        mid = (l + r) >> 1;
    }
}

class SegmentTree {
    Node root;

    public SegmentTree(int l, int r) {
        root = new Node(l, r);
    }

    public void modify(int l, int r, int v, Node node) {
        if (node == null) {
            node = root;
        }
        if (l <= node.l && node.r <= r) {
            node.v = v;
            return;
        }
        pushDown(node);
        if (l <= node.mid) {
            modify(l, r, v, node.left);
        }
        if (r > node.mid) {
            modify(l, r, v, node.right);
        }
        pushUp(node);
    }

    public void pushDown(Node node) {
        if (node.left == null) {
            node.left = new Node(node.l, node.mid);
        }
        if (node.right == null) {
            node.right = new Node(node.mid + 1, node.r);
        }
    }

    public void pushUp(Node node) {
        node.v = node.left.v + node.right.v;
    }

    public int query(int l, int r, Node node) {
        if (node == null) {
            node = root;
        }
        if (l <= node.l && node.r <= r) {
            return node.v;
        }
        pushDown(node);
        int ans = 0;
        if (l <= node.mid) {
            ans += query(l, r, node.left);
        }
        if (r > node.mid) {
            ans += query(l, r, node.right);
        }
        return ans;
    }
}


class NumArray {

    SegmentTree st;

    public NumArray(int[] nums) {
        st = new SegmentTree(0, 30010);
        for (int i = 0; i < nums.length; i++) {
            st.modify(i, i, nums[i], null);
        }
    }

    public void update(int index, int val) {
        st.modify(index, index, val, null);
    }

    public int sumRange(int left, int right) {
        return st.query(left, right, null);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */