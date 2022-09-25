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
    public TreeNode reverseOddLevels(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        int level = 1;
        while (!q.isEmpty()) {
            int m = q.size();
            List<TreeNode> tmp = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                TreeNode cur = q.pollFirst();
                if (cur.left != null) {
                    tmp.add(cur.left);
                }
                if (cur.right != null) {
                    tmp.add(cur.right);
                }
            }
            if (level % 2 != 0) {
                int l = 0, r = tmp.size() - 1;
                while (l < r) {
                    int t = tmp.get(r).val;
                    tmp.get(r).val = tmp.get(l).val;
                    tmp.get(l).val = t;
                    l++;
                    r--;
                }
            }
            q.addAll(tmp);
            level++;
        }
        return root;
    }
}
