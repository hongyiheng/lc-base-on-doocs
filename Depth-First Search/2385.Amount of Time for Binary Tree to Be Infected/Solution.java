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

    int ans, start;

    public int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] l = dfs(root.left), r = dfs(root.right);
        if (root.val == start) {
            ans = Math.max(ans, Math.max(l[1], r[1]));
            return new int[]{1, 0};
        } else if (l[0] == 1 || r[0] == 1) {
            ans = Math.max(ans, l[1] + r[1] + 1);
            return new int[]{1, l[0] == 1 ? l[1] + 1: r[1] + 1};
        }
        return new int[]{0, Math.max(l[1], r[1]) + 1};
    }

    public int amountOfTime(TreeNode root, int start) {
        ans = 0;
        this.start = start;
        dfs(root);
        return ans;
    }
}