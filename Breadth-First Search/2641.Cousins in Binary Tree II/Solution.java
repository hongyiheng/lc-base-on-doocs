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
    public TreeNode replaceValueInTree(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        root.val = 0;
        while (!q.isEmpty()) {
            int s = 0;
            for (TreeNode node : q) {
                s += node.left != null ? node.left.val : 0;
                s += node.right != null ? node.right.val : 0;
            }
            int m = q.size();
            for (int i = 0; i < m; i++) {
                TreeNode node = q.pollFirst();
                int childVal = node.left != null ? node.left.val : 0;
                childVal += node.right != null ? node.right.val : 0;
                childVal = s - childVal;
                if (node.left != null) {
                    node.left.val = childVal;
                    q.add(node.left);
                }
                if (node.right != null) {
                    node.right.val = childVal;
                    q.add(node.right);
                }
            }
        }
        return root;
    }
}