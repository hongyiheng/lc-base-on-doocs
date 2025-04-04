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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) {
            return root;
        }
        int l = dfs(root.left, 0), r = dfs(root.right, 0);
        if (l == r) {
            return root;
        }
        return l > r ? lcaDeepestLeaves(root.left) : lcaDeepestLeaves(root.right);
    }

    public int dfs(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        int l = dfs(root.left, depth + 1), r = dfs(root.right, depth + 1);
        return Math.max(l, r);
    }
}