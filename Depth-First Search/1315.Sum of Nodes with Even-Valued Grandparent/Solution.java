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
    List<TreeNode> even = new ArrayList<>();

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.val % 2 == 0) {
            even.add(root);
        }
        dfs(root.left);
        dfs(root.right);
    }


    public int sumEvenGrandparent(TreeNode root) {
        dfs(root);
        int ans = 0;
        for (TreeNode node : even) {
            if (node.left != null) {
                if (node.left.left != null) {
                    ans += node.left.left.val;
                }
                if (node.left.right != null) {
                    ans += node.left.right.val;
                }
            }
            if (node.right != null) {
                if (node.right.left != null) {
                    ans += node.right.left.val;
                }
                if (node.right.right != null) {
                    ans += node.right.right.val;
                }
            }
        }
        return ans;
    }
}
