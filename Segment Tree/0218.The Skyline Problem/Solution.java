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
        this.mid = (l + r) >>> 1;
    }
}

class SegmentTree {
    private Node root = new Node(0, Integer.MAX_VALUE);

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

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        SegmentTree st = new SegmentTree();
        Arrays.sort(buildings, (a, b) -> a[2] - b[2]);
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> a - b);
        for (int[] item : buildings) {
            st.modify(item[0], item[1] - 1, item[2]);
            q.add(item[0]);
            q.add(item[1]);
        }
        List<List<Integer>> ans = new ArrayList<>();
        int last = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            int w = st.query(cur, cur);
            if (w != last) {
                List<Integer> item = new ArrayList<>();
                item.add(cur);
                item.add(w);
                ans.add(item);
                last = w;
            }
        }
        return ans;
    }
}