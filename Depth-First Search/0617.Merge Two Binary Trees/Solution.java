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
    public void dfs(TreeNode a, TreeNode b, TreeNode cur) {
        if (a == null && b == null) {
            return;
        }
        cur.val = (a == null ? 0 : a.val) + (b == null ? 0 : b.val);
        if ((a != null && a.left != null) || (b != null && b.left != null)) {
            cur.left = new TreeNode();
            dfs(a == null ? null : a.left, b == null ? null : b.left, cur.left);
        }
        if ((a != null && a.right != null) || (b != null && b.right != null)) {
            cur.right = new TreeNode();
            dfs(a == null ? null : a.right, b == null ? null : b.right, cur.right);
        }
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        TreeNode root = new TreeNode();
        dfs(root1, root2, root);
        return root;
    }
}
