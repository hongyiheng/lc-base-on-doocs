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
    public int goodNodes(TreeNode root) {
        Deque<Pair<TreeNode, Integer>> q = new ArrayDeque<>();
        q.addLast(new Pair(root, root.val));
        int ans = 0;
        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> cur = q.pollFirst();
            TreeNode node = cur.getKey();
            int nx = Math.max(node.val, cur.getValue());
            if (node.left != null) {
                q.addLast(new Pair<>(node.left, nx));
            }
            if (node.right != null) {
                q.addLast(new Pair<>(node.right, nx));
            }
            ans += node.val >= cur.getValue() ? 1 : 0;
        }
        return ans;
    }
}
