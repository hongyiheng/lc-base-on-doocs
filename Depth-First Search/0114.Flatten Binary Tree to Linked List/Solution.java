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

    List<Integer> q = new ArrayList<>();

    public void flatten(TreeNode root) {
        dfs(root);
        TreeNode tmp = root;
        for (int i = 0; i < q.size(); i++) {
            tmp.left = null;
            tmp.val = q.get(i);
            if (tmp.right == null && i != q.size() - 1) {
                tmp.right = new TreeNode();
            }
            tmp = tmp.right;
        }
    }


    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        q.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}