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
    public boolean isCompleteTree(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        int last = 0;
        while (!q.isEmpty()) {
            int n = q.size();
            boolean end = false;
            for (int i = 0; i < n; i++) {
                TreeNode v = q.pollFirst();
                if (v.left != null) {
                    if (end) {
                        return false;
                    }
                    q.addLast(v.left);
                } else {
                    end = true;
                }
                if (v.right != null) {
                    if (end) {
                        return false;
                    }
                    q.addLast(v.right);
                } else {
                    end = true;
                }
            }
            if (last != 0 && !q.isEmpty() && last * 2 != n) {
                return false;
            }
            last = n;
        }
        return true;
    }
}