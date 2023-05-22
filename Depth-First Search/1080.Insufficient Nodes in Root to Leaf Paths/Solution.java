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

    int limit;

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        this.limit = limit;
        return dfs(root, 0).getKey();
    }

    public Pair<TreeNode, Integer> dfs(TreeNode root, int s) {
        s += root.val;
        if (root.left == null && root.right == null) {
            return new Pair<>(s < limit ? null: root, s);
        }
        int mx = -0x3f3f3f3f;
        if (root.left != null) {
            Pair<TreeNode, Integer> left = dfs(root.left, s);
            root.left = left.getKey();
            mx = Math.max(mx, left.getValue());
        }
        if (root.right != null) {
            Pair<TreeNode, Integer> right = dfs(root.right, s);
            root.right = right.getKey();
            mx = Math.max(mx, right.getValue());
        }
        return new Pair<>(mx < limit ? null : root, mx);
    }
}
