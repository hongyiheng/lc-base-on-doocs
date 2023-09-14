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
    public int dfs(TreeNode root, int cnt, boolean left) {
        if (root == null) {
            return 0;
        }
        int l = 0, r = 0;
        if (left) {
            l = dfs(root.left, 1, true);
            r = dfs(root.right, cnt + 1, false);
        } else {
            l = dfs(root.left, cnt + 1, true);
            r = dfs(root.right, 1, false);
        }
        return Math.max(cnt, Math.max(l, r));
    }

    public int longestZigZag(TreeNode root) {
        return dfs(root, 0, true);
    }
}