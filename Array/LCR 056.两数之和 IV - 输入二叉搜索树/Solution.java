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

    Map<Integer, Boolean> g = new HashMap<>();
    int k;

    public boolean dfs(TreeNode root) {
        if (root == null) {
            return false;
        }
        boolean ans = dfs(root.left);
        if (g.containsKey(k - root.val)) {
            return true;
        }
        g.put(root.val, true);
        return ans || dfs(root.right);
    }

    public boolean findTarget(TreeNode root, int k) {
        this.k = k;
        return dfs(root);
    }
}