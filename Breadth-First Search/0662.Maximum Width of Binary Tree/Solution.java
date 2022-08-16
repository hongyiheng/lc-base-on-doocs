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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = 1;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        root.val = 0;
        while (!q.isEmpty()) {
            int n = q.size();
            ans = Math.max(ans, q.peekLast().val - q.peekFirst().val + 1);
            for (int i = 0; i < n; i++) {
                TreeNode cur = q.pollFirst();
                if (cur.left != null) {
                    cur.left.val = cur.val * 2 + 1;
                    q.addLast(cur.left);
                }
                if (cur.right != null) {
                    cur.right.val = cur.val * 2 + 2;
                    q.addLast(cur.right);
                }
            }
        }
        return ans;
    }
}