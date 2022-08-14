class Node {
    Map<Integer, Node> child;
    int cnt;

    public Node() {
        child = new HashMap<>();
        cnt = 0;
    }
}

class Solution {
    Node root;

    public void insert(int[] row) {
        Node head = root;
        for (int v : row) {
            if (!head.child.containsKey(v)) {
                head.child.put(v, new Node());
            }
            head = head.child.get(v);
        }
        head.cnt++;
    }

    public int equalPairs(int[][] grid) {
        root = new Node();
        for (int[] row : grid) {
            insert(row);
        }
        int ans = 0, n = grid.length;
        for (int j = 0; j < n; j++) {
            Node head = root;
            for (int i = 0; i < n; i++) {
                int v = grid[i][j];
                if (!head.child.containsKey(v)) {
                    break;
                }
                head = head.child.get(v);
            }
            ans += head.cnt;
        }
        return ans;
    }
}