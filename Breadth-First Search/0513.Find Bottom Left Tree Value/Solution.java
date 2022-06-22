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
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        int ans = root.val;
        q.addLast(root);
        while (!q.isEmpty()) {
            int m = q.size();
            ans = q.peek().val;
            for (int i = 0; i < m; i++) {
                TreeNode cur = q.pollFirst();
                if (cur.left != null) {
                    q.addLast(cur.left);
                }
                if (cur.right != null) {
                    q.addLast(cur.right);
                }
            }
        }
        return ans;
    }
}