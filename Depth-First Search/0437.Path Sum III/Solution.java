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
    int ans;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        ans = 0;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            dfs(cur, targetSum);
            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
        }
        return ans;
    }

    public void dfs(TreeNode root, long t) {
        if (root == null) {
            return;
        }
        if (root.val == t) {
            ans++;
        }
        dfs(root.left, t - root.val);
        dfs(root.right, t - root.val);
    }
}