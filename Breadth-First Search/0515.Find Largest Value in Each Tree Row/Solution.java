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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        while (!q.isEmpty()) {
            int m = q.size(), mx = Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {
                TreeNode cur = q.pollFirst();
                mx = Math.max(mx, cur.val);
                if (cur.left != null) {
                    q.addLast(cur.left);
                }
                if (cur.right != null) {
                    q.addLast(cur.right);
                }
            }
            ans.add(mx);
        }
        return ans;
    }
}
