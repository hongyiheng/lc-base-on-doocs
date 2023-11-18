class Solution {

    class Node {
        int l;
        int r;
        int mid;
        int v;
        Node left;
        Node right;

        public Node (int l, int r) {
            this.l = l;
            this.r = r;
            mid = (l + r) >> 1;
            v = -1;
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
                node.v = Math.max(node.v, v);
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
            node.v = Math.max(node.left.v, node.right.v);
        }

        public int query(int l, int r, Node node) {
            if (node == null) {
                node = root;
            }
            if (l <= node.l && node.r <= r) {
                return node.v;
            }
            pushDown(node);
            int ans = -1;
            if (l <= node.mid) {
                ans = Math.max(ans, query(l, r, node.left));
            }
            if (r > node.mid) {
                ans = Math.max(ans, query(l, r, node.right));
            }
            return ans;
        }
    }

    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        int n = nums1.length, m = queries.length;
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = nums1[i];
            nums[i][1] = nums2[i];
        }
        int[][] q = new int[m][3];
        for (int i = 0; i < m; i++) {
            q[i][0] = queries[i][0];
            q[i][1] = queries[i][1];
            q[i][2] = i;
        }
        Arrays.sort(nums, (a, b) -> b[0] - a[0]);
        Arrays.sort(q, (a, b) -> b[0] - a[0]);

        int inf = (int)1e9;
        SegmentTree st = new SegmentTree(0, inf);
        int[] ans = new int[m];
        int j = 0;
        for (int[] qs : q) {
            int x = qs[0], y = qs[1], i = qs[2];
            while (j < n && nums[j][0] >= x) {
                st.modify(nums[j][1], nums[j][1], nums[j][0] + nums[j][1], null);
                j++;
            }
            ans[i] = st.query(y, inf, null);
        }
        return ans;
    }
}