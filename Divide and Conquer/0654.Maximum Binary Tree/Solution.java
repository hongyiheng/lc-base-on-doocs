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
    int[] nums;

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        this.nums = nums;
        return dfs(0, nums.length - 1);
    }

    public TreeNode dfs(int l, int r) {
        if (l > r) {
            return null;
        }
        int mx = l;
        for (int i = l; i <= r; i++) {
            if (nums[mx] < nums[i]) {
                mx = i;
            }
        }
        TreeNode root = new TreeNode(nums[mx]);
        root.left = dfs(l, mx - 1);
        root.right = dfs(mx + 1, r);
        return root;
    }
}