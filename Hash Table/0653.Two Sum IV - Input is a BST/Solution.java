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
    Set<Integer> s = new HashSet<>();
    int k;
    public boolean findTarget(TreeNode root, int k) {
        this.k = k;
        return dfs(root);
    }

    public boolean dfs(TreeNode root) {
        if (root == null) {
            return false;
        }
        if (s.contains(root.val)) {
            return true;
        }
        s.add(k - root.val);
        boolean left = dfs(root.left);
        boolean right = dfs(root.right);
        return left || right;
    }
}