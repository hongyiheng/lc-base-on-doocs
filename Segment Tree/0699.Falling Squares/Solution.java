class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        SegmentTree st = new SegmentTree();
        List<Integer> ans = new ArrayList<>();
        int cur = 0;
        for (int[] item : positions) {
            int h = st.query(item[0], item[0] + item[1] - 1);
            st.modify(item[0], item[0] + item[1] - 1, h + item[1]);
            cur = Math.max(cur, h + item[1]);
            ans.add(cur);
        }
        return ans;
    }
}

class SegmentTree {
    private Node root = new Node(1, (int)1e9);

    public SegmentTree() {
    }

    public int query(int l, int r) {
        return query(l, r, root);
    }

    public int query(int l, int r, Node node) {
        if (l > r) {
            return 0;
        }
        if (node.l >= l && node.r <= r) {
            return node.v;
        }
        pushDown(node);
        int v = 0;
        if (l <= node.mid) {
            v = Math.max(v, query(l, r, node.left));
        }
        if (r > node.mid) {
            v = Math.max(v, query(l, r, node.right));
        }
        return v;
    }

    public void modify(int l, int r, int v) {
        modify(l, r, v, root);
    }

    public void modify(int l, int r, int v, Node node) {
        if (l > r) {
            return;
        }
        if (node.l >= l && node.r <= r) {
            node.v = v;
            node.add = v;
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

    public void pushUp(Node node) {
        node.v = Math.max(node.left.v, node.right.v);
    }

    public void pushDown(Node node) {
        if (node.left == null) {
            node.left = new Node(node.l, node.mid);
        }
        if (node.right == null) {
            node.right = new Node(node.mid + 1, node.r);
        }
        if (node.add != 0) {
            Node left = node.left, right = node.right;
            left.add = node.add;
            right.add = node.add;
            left.v = node.v;
            right.v = node.v;
            node.add = 0;
        }
    }
}

class Node {
    Node left;
    Node right;
    int l;
    int r;
    int mid;
    int v;
    int add;

    public Node(int l, int r) {
        this.l = l;
        this.r = r;
        this.mid = (l + r) >> 1;
    }
}