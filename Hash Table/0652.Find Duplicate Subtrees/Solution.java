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
    Map<String, Pair<Integer, TreeNode>> mp = new HashMap<>();
    List<TreeNode> ans;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        ans = new ArrayList<>();
        dfs(root);
        return ans;
    }

    public String dfs(TreeNode root) {
        if (root == null) {
            return ".";
        }
        String k = root.val + "," + dfs(root.left) + "," + dfs(root.right);
        Pair<Integer, TreeNode> cur = mp.getOrDefault(k, new Pair(0, root));
        if (cur.getKey() == 1) {
            ans.add(root);
        }
        mp.put(k, new Pair(cur.getKey() + 1, root));
        return k;
    }
}