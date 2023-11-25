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

    int[] cnt;
    int ans;

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        cnt[root.val]++;
        if (root.left == null && root.right == null) {
            int k = 0;
            for (int v : cnt) {
                k += v % 2;
            }
            ans += k <= 1 ? 1 : 0;
        }
        dfs(root.left);
        dfs(root.right);
        cnt[root.val]--;
    }

    public int pseudoPalindromicPaths (TreeNode root) {
        cnt = new int[10];
        ans = 0;
        dfs(root);
        return ans;
    }
}