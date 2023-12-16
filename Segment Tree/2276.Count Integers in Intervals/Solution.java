class Node {
    int l;
    int r;
    int mid;
    int v;
    boolean lazy;
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

    public void modify(int l, int r, Node node) {
        if (node == null) {
            node = root;
        }
        if (l <= node.l && node.r <= r) {
            node.v = node.r - node.l + 1;
            node.lazy = true;
            return;
        }
        pushDown(node);
        if (l <= node.mid) {
            modify(l, r, node.left);
        }
        if (node.mid < r) {
            modify(l, r, node.right);
        }
        pushUp(node);
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
        if (node.mid < r) {
            ans += query(l, r, node.right);
        }
        return ans;
    }

    public void pushDown(Node node) {
        if (node.left == null) {
            node.left = new Node(node.l, node.mid);
        }
        if (node.right == null) {
            node.right = new Node(node.mid + 1, node.r);
        }
        if (node.lazy) {
            node.left.v = node.left.r - node.left.l + 1;
            node.left.lazy = true;
            node.right.v = node.right.r - node.right.l + 1;
            node.right.lazy = true;
        }
        node.lazy = false;
    }

    public void pushUp(Node node) {
        node.v = node.left.v + node.right.v;
    }
}

class CountIntervals {
    int M = (int)1e9;
    SegmentTree st;

    public CountIntervals() {
        st = new SegmentTree(1, M);
    }

    public void add(int left, int right) {
        st.modify(left, right, null);
    }

    public int count() {
        return st.query(1, M, null);
    }
}

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */