class Node {
    int l;
    int r;
    int mid;
    int v;
    int lazy;
    Node left;
    Node right;

    public Node(int l, int r) {
        this.l = l;
        this.r = r;
        this.mid = (l + r) >> 1;
        this.v = 0;
        this.lazy = 0;
    }
}

class SegmentTree {

    Node root;

    public SegmentTree() {
        root = new Node(0, (int)1e6);
    }

    public void modify(int l, int r, Node node) {
        if (node == null) {
            node = root;
        }
        if (l > r) {
            return;
        }
        if (l <= node.l && node.r <= r) {
            node.v = node.r - node.l + 1 - node.v;
            node.lazy ^= 1;
            return;
        }
        pushDown(node);
        if (l <= node.mid) {
            modify(l, r, node.left);
        }
        if (r > node.mid) {
            modify(l, r, node.right);
        }
        pushUp(node);
    }

    public int query(int l, int r, Node node) {
        if (node == null) {
            node = root;
        }
        if (l > r) {
            return 0;
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

    public void pushUp(Node node) {
        node.v = node.left.v + node.right.v;
    }

    public void pushDown(Node node) {
        if (node.left == null) {
            node.left = new Node(node.l, node.mid);
        }
        if (node.right == null) {
            node.right = new Node(node.mid + 1, node.r);
        }
        if (node.lazy != 0) {
            node.left.v = node.left.r - node.left.l + 1 - node.left.v;
            node.left.lazy ^= 1;
            node.right.v = node.right.r - node.right.l + 1 - node.right.v;
            node.right.lazy ^= 1;
            node.lazy = 0;
        }
    }
}

class Solution {
    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        SegmentTree st = new SegmentTree();
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == 1) {
                st.modify(i, i, null);
            }
        }
        long s = 0;
        for (int v : nums2) {
            s += v;
        }
        List<Long> ans = new ArrayList<>();
        for (int[] q : queries) {
            if (q[0] == 1) {
                st.modify(q[1], q[2], null);
            } else if (q[0] == 2) {
                s += (long) q[1] * st.query(0, (int) 1e6, null);
            } else {
                ans.add(s);
            }
        }
        return ans.stream().mapToLong(Long::longValue).toArray();
    }
}