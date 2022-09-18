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
    Map<Integer, List<Integer>> mp = new HashMap<>();

    public List<List<Integer>> findLeaves(TreeNode root) {
        int n = dfs(root);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            ans.add(mp.get(i));
        }
        return ans;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = dfs(root.left), r = dfs(root.right);
        mp.computeIfAbsent(Math.max(l, r) + 1, k -> new ArrayList<>()).add(root.val);
        return Math.max(l, r) + 1;
    }
}