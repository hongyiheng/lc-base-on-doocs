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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode ans = new TreeNode(val);
            ans.left = root;
            return ans;
        }
        int d = 1;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        while (!q.isEmpty()) {
            int m = q.size();
            for (int i = 0; i < m; i++) {
                TreeNode cur = q.pollFirst();
                TreeNode l = cur.left, r = cur.right;
                if (d + 1 == depth) {
                    cur.left = new TreeNode(val);
                    cur.right = new TreeNode(val);
                }
                if (l != null) {
                    if (d + 1 == depth) {
                        cur.left.left = l;
                    }
                    q.addLast(l);
                }
                if (r != null) {
                    if (d + 1 == depth) {
                        cur.right.right = r;
                    }
                    q.addLast(r);
                }
            }
            d++;
        }
        return root;
    }
}
