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
    Map<TreeNode, Integer> h = new HashMap<>();
    Map<Integer, Integer> res = new HashMap<>();

    public int[] treeQueries(TreeNode root, int[] queries) {
        getHeight(root);
        dfs(root, -1, 0);
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = res.get(queries[i]);
        }
        return ans;
    }

    public void dfs(TreeNode node, int depth, int restHeight) {
        if (node == null) {
            return;
        }
        res.put(node.val, restHeight);
        depth++;
        dfs(node.left, depth, Math.max(restHeight, depth + h.getOrDefault(node.right, 0)));
        dfs(node.right, depth, Math.max(restHeight, depth + h.getOrDefault(node.left, 0)));
    }

    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int ans = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        h.put(node, ans);
        return ans;
    }
}
