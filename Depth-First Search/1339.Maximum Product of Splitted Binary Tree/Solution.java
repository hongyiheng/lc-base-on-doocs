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

    long ans = 0, s = 0;

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int res = root.val + left + right;
        root.val = res;
        return res;
    }

    public void dfs1(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs1(root.left);
        dfs1(root.right);
        ans = Math.max(ans, (long)(s - root.val) * root.val);
    }

    public int maxProduct(TreeNode root) {
        s = dfs(root);
        dfs1(root);
        return (int)(ans % ((int)1e9 + 7));
    }
}