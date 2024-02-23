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
    public long kthLargestLevelSum(TreeNode root, int k) {
        Deque<TreeNode> q = new ArrayDeque();
        q.add(root);
        List<Long> rs = new ArrayList<>();
        while (!q.isEmpty()) {
            long s = 0;
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode cur = q.pollFirst();
                s += cur.val;
                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }
            }
            rs.add(s);
        }
        if (rs.size() < k) {
            return -1;
        }
        rs.sort((a, b) -> b - a > 0 ? 1 : -1);
        return rs.get(k - 1);
    }
}