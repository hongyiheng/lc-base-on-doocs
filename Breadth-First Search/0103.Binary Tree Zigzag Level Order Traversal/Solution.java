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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        boolean re = true;
        while (!q.isEmpty()) {
            int m = q.size();
            Deque<Integer> row = new ArrayDeque<>();
            for (int i = 0; i < m; i++) {
                TreeNode cur = q.pollFirst();
                if (re) {
                    row.addLast(cur.val);
                } else {
                    row.addFirst(cur.val);
                }
                if (cur.left != null) {
                    q.addLast(cur.left);
                }
                if (cur.right != null) {
                    q.addLast(cur.right);
                }
            }
            ans.add(new ArrayList(row));
            re = !re;
        }
        return ans;
    }
}