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
    public int maxLevelSum(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        long mx = root.val;
        int ans = 1, row = 1;
        while (!q.isEmpty()) {
            int m = q.size();
            long tmp = 0;
            for (int i = 0; i < m; i++) {
                TreeNode cur = q.pollFirst();
                tmp += cur.val;
                if (cur.left != null) {
                    q.addLast(cur.left);
                }
                if (cur.right != null) {
                    q.addLast(cur.right);
                }
            }
            if (tmp > mx) {
                mx = tmp;
                ans = row;
            }
            row++;
        }
        return ans;
    }
}