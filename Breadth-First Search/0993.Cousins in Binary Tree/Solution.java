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
    public boolean isCousins(TreeNode root, int x, int y) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            boolean a = false, b = false;
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode v = q.pollFirst();
                if (v.left != null) {
                    if ((v.left.val == x && b) || v.left.val == y && a) {
                        return true;
                    }
                }
                if (v.right != null) {
                    if ((v.right.val == x && b) || v.right.val == y && a) {
                        return true;
                    }
                }
                if ((v.left != null && v.left.val == x) || (v.right != null && v.right.val == x)) {
                    a = true;
                }
                if ((v.left != null && v.left.val == y) || (v.right != null && v.right.val == y)) {
                    b = true;
                }
                if (v.left != null) {
                    q.add(v.left);
                }
                if (v.right != null) {
                    q.add(v.right);
                }
            }
        }
        return false;
    }
}