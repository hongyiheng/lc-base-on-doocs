class Node {
    Node left;
    Node right;
    int l;
    int r;
    int mid;
    int v;

    public Node(int l, int r) {
        this.l = l;
        this.r = r;
        this.mid = (l + r) >> 1;
    }
}

class SegementTree {
    Node root;

    public SegementTree() {
        root = new Node(0, (int)1e9);
    }

    public int queryRange(int l, int r, Node node) {
        if (l > r) {
            return 0;
        }
        node = node == null ? root : node;
        if (l <= node.l && node.r <= r) {
            return node.v;
        }
        pushDown(node);
        int ans = 0;
        if (l <= node.mid) {
            ans = Math.max(ans, queryRange(l, r, node.left));
        }
        if (node.mid < r) {
            ans = Math.max(ans, queryRange(l, r, node.right));
        }
        return ans;
    }

    public void modifyRange(int l, int r, int v, Node node) {
        if (l > r) {
            return;
        }
        node = node == null ? root : node;
        if (l <= node.l && node.r <= r) {
            node.v = Math.max(node.v, v);
            return;
        }
        pushDown(node);
        if (l <= node.mid) {
            modifyRange(l, r, v, node.left);
        }
        if (node.mid < r) {
            modifyRange(l, r, v, node.right);
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
        node.v = Math.max(node.left.v, node.right.v);
    }

}

class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        SegementTree st = new SegementTree();
        for (int[] e : items) {
            st.modifyRange(e[0], e[0], e[1], null);
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = st.queryRange(1, queries[i], null);
        }
        return ans;
    }
}