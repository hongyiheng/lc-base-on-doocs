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

    int ans;

    public int minCameraCover(TreeNode root) {
        ans = 0;
        if (dfs(root) == 0) {
            ans++;
        }
        return ans;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int l = dfs(root.left), r = dfs(root.right);
        if (l == 0 || r == 0) {
            ans++;
            return 1;
        }
        return l == 1 || r == 1 ? -1 : 0;
    }
}