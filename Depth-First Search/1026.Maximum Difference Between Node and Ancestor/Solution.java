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
    int ans = 0;

    public void dfs(int mx, int mi, TreeNode root) {
        if (root == null) {
            return;
        }
        ans = Math.max(ans, Math.abs(mx - root.val));
        ans = Math.max(ans, Math.abs(mi - root.val));
        mx = Math.max(mx, root.val);
        mi = Math.min(mi, root.val);
        dfs(mx, mi, root.left);
        dfs(mx, mi, root.right);
    }

    public int maxAncestorDiff(TreeNode root) {
        dfs(root.val, root.val, root);
        return ans;
    }
}