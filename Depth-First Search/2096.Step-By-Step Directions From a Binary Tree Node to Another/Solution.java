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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder sp = new StringBuilder(), tp = new StringBuilder();
        dfs(root, startValue, sp);
        dfs(root, destValue, tp);
        String s = sp.toString(), t = tp.toString();
        while (s.length() > 0 && t.length() > 0 && s.charAt(0) == t.charAt(0)) {
            s = s.substring(1);
            t = t.substring(1);
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            ans.append("U");
        }
        ans.append(t);
        return ans.toString();
    }

    public boolean dfs(TreeNode root, int t, StringBuilder s) {
        if (root == null) {
            return false;
        }
        if (root.val == t) {
            return true;
        }
        s.append("L");
        if (dfs(root.left, t, s)) {
            return true;
        }
        s.deleteCharAt(s.length() - 1);
        s.append("R");
        if (dfs(root.right, t, s)) {
            return true;
        }
        s.deleteCharAt(s.length() - 1);
        return false;
    }
}
