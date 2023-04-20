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

    List<String> q = new ArrayList<>();

    public void dfs(TreeNode root, List<String> path) {
        if (root.left == null && root.right == null) {
            q.add(new StringBuilder(String.join("", path)).reverse().toString());
            return;
        }
        if (root.left != null) {
            path.add(String.valueOf((char) ('a' + root.left.val)));
            dfs(root.left, path);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            path.add(String.valueOf((char) ('a' + root.right.val)));
            dfs(root.right, path);
            path.remove(path.size() - 1);
        }
    }


    public String smallestFromLeaf(TreeNode root) {
        List<String> path = new ArrayList<>();
        path.add(String.valueOf((char) ('a' + root.val)));
        dfs(root, path);
        Collections.sort(q);
        return q.get(0);
    }
}
