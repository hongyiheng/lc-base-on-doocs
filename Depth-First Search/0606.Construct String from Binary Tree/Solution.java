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
    StringBuilder ans = new StringBuilder();

    public String tree2str(TreeNode root) {
        dfs(root);
        return ans.toString();
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        ans.append(root.val);
        if (root.left == null && root.right == null) {
            return;
        }
        ans.append("(");
        dfs(root.left);
        ans.append(")");
        if (root.right != null) {
            ans.append("(");
            dfs(root.right);
            ans.append(")");
        }
    }
}