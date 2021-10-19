/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }   
        if (p.val > q.val) {
            return lowestCommonAncestor(root, q, p);
        }
        if (q.val < root.val) {
            return lowestCommonAncestor(root.left, q, p);
        }
        if (p.val > root.val) {
            return lowestCommonAncestor(root.right, q, p);
        }
        return root;
    }
}