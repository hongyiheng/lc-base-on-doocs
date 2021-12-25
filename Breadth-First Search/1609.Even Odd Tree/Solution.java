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
    public boolean isEvenOddTree(TreeNode root) {
        Deque<TreeNode> stk = new ArrayDeque();
        boolean cur = true;
        stk.offer(root);
        while (!stk.isEmpty()) {
            List<TreeNode> childs = new ArrayList<>();
            int order = cur ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            while (!stk.isEmpty()) {
                TreeNode tmp = stk.poll();
                if (cur) {
                    if (tmp.val % 2 == 0 || order >= tmp.val) {
                        return false;
                    }
                } else {
                    if (tmp.val % 2 != 0 || order <= tmp.val) {
                        return false;
                    }
                }
                order = tmp.val;
                childs.add(tmp.left);
                childs.add(tmp.right);
            }
            for (TreeNode item : childs) {
                if (item == null) {
                    continue;
                }
                stk.offer(item);
            }
            cur = !cur;
        }
        return true;
    }
}