class Node {
    int l;
    int r;
    int mid;
    int lazy;
    boolean v;
    Node left;
    Node right;

    public Node(int l, int r) {
        this.l = l;
        this.r = r;
        mid = (l + r) >> 1;
    }
}

class SegmentTree {
    private Node root = new Node(1, (int)1e9);

    public SegmentTree() {

    }

    public void modify(int l, int r, int v, Node node) {
        if (node == null) {
            node = root;
        }
        if (l <= node.l && node.r <= r) {
            node.v = v == 1;
            node.lazy = v;
            return;
        }
        pushdown(node);
        if (l <= node.mid) {
            modify(l, r, v, node.left);
        }
        if (r > node.mid) {
            modify(l, r, v, node.right);
        }
        pushup(node);
    }

    public boolean query(int l, int r, Node node) {
        if (node == null) {
            node = root;
        }
        if (l <= node.l && node.r <= r) {
            return node.v;
        }
        pushdown(node);
        boolean ans = true;
        if (l <= node.mid) {
            ans = ans && query(l, r, node.left);
        }
        if (r > node.mid) {
            ans = ans && query(l, r, node.right);
        }
        return ans;
    }

    public void pushup(Node node) {
        node.v = node.left.v && node.right.v;
    }

    public void pushdown(Node node) {
        if (node.left == null) {
            node.left = new Node(node.l, node.mid);
        }
        if (node.right == null) {
            node.right = new Node(node.mid + 1, node.r);
        }
        if (node.lazy != 0) {
            node.left.lazy = node.lazy;
            node.right.lazy = node.lazy;
            node.left.v = node.lazy == 1;
            node.right.v = node.lazy == 1;
        }
        node.lazy = 0;
    }
}

class RangeModule {
    SegmentTree tree;

    public RangeModule() {
        tree = new SegmentTree();
    }

    public void addRange(int left, int right) {
        tree.modify(left, right - 1, 1, null);
    }

    public boolean queryRange(int left, int right) {
        return tree.query(left, right - 1, null);
    }

    public void removeRange(int left, int right) {
        tree.modify(left, right - 1, -1, null);
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
