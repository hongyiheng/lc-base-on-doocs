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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> nums1 = new ArrayList<>();
        List<Integer> nums2 = new ArrayList<>();
        dfs(root1, nums1);
        dfs(root2, nums2);
        int idx1 = 0, idx2 = 0;
        List<Integer> ans = new ArrayList<>();
        while (idx1 < nums1.size() || idx2 < nums2.size()) {
            if (idx1 < nums1.size() && idx2 < nums2.size()) {
                if (nums1.get(idx1) <= nums2.get(idx2)) {
                    ans.add(nums1.get(idx1));
                    idx1++;
                } else {
                    ans.add(nums2.get(idx2));
                    idx2++;
                }
                continue;
            }
            if (idx1 < nums1.size()) {
                ans.add(nums1.get(idx1));
                idx1++;
            } else {
                ans.add(nums2.get(idx2));
                idx2++;
            }
        }
        return ans;
    }

    public void dfs(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        dfs(root.left, nums);
        nums.add(root.val);
        dfs(root.right, nums);
    }
}