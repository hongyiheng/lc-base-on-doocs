/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        int M = 1010, N = 2010;
        PriorityQueue<Integer>[][] g = new PriorityQueue[M][N];
        Deque<Pair<int[], TreeNode>> q = new ArrayDeque<>();
        q.addLast(new Pair(new int[]{0, 1000}, root));
        while (!q.isEmpty()) {
            int m = q.size();
            for (int i = 0; i < m; i++) {
                Pair<int[], TreeNode> cur = q.pollFirst();
                int x = cur.getKey()[0], y = cur.getKey()[1];
                TreeNode node = cur.getValue();
                if (g[x][y] == null) {
                    g[x][y] = new PriorityQueue();
                }
                g[x][y].add(node.val);
                if (node.left != null) {
                    q.addLast(new Pair(new int[]{x + 1, y - 1}, node.left));
                }
                if (node.right != null) {
                    q.addLast(new Pair(new int[]{x + 1, y + 1}, node.right));
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int j = 0; j < N; j++) {
            List<Integer> col = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                if (g[i][j] != null) {
                    while (!g[i][j].isEmpty()) {
                        col.add(g[i][j].poll());
                    }
                }
            }
            if (!col.isEmpty()) {
                ans.add(col);
            }
        }
        return ans;
    }
}