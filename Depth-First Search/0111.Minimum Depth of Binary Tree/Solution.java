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
    int ans = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(1, root);
        return ans;
    }

    public void dfs(int depth, TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
             if (depth < ans) {
                ans = depth;
            }
            return;
        }
        dfs(depth + 1, root.left);
        dfs(depth + 1, root.right);
    }
}