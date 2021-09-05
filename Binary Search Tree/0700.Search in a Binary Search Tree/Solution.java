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
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return root;
        }
        Deque<TreeNode> stk = new ArrayDeque<>();
        stk.addLast(root);
        while(!stk.isEmpty()) {
            TreeNode cur = stk.pollLast();
            if (cur.val == val) {
                return cur;
            } else {
                if (cur.val > val && cur.left != null) {
                    stk.addLast(cur.left);
                }
                if (cur.val < val && cur.right != null) {
                    stk.addLast(cur.right);
                }
            }
        }
        return null;
    }
}