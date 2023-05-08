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
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    public int dfs(TreeNode root, int x) {
        if (root == null) {
            return 0;
        }
        int mx = Math.max(root.val, x);
        int left = dfs(root.left, mx), right = dfs(root.right, mx);
        return root.val >= x ? left + right + 1 : left + right;
    }
}
