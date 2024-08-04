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

    public boolean dfs(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root != null && subRoot != null) {
            if (root.val != subRoot.val) {
                return false;
            }
            return dfs(root.left, subRoot.left) && dfs(root.right, subRoot.right);
        }
        return false;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        return dfs(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}