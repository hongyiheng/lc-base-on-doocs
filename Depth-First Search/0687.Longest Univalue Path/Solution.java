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
    int ans = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int cur = 0, item = 0;
        if (root.left != null && root.left.val == root.val) {
            item = left + 1;
            cur = left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            item = Math.max(item, right + 1);
            cur += right + 1;
        }
        ans = Math.max(ans, item);
        ans = Math.max(ans, cur);
        return item;

    }
}