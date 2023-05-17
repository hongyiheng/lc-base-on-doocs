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

    int ans = 0;
    Map<TreeNode, Integer> f = new HashMap<>();

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return ans;
    }

    public Pair<Boolean, int[]> dfs(TreeNode root) {
        boolean flag = true;
        int mx = root.val, mi = root.val;
        if (root.left != null) {
            Pair<Boolean, int[]> left = dfs(root.left);
            int lMx = left.getValue()[0], lMi = left.getValue()[1];
            flag = flag && left.getKey() && lMx < root.val;
            mx = Math.max(mx, lMx);
            mi = Math.min(mi, lMi);
        }
        if (root.right != null) {
            Pair<Boolean, int[]> right = dfs(root.right);
            int rMx = right.getValue()[0], rMi = right.getValue()[1];
            flag = flag && right.getKey() && rMi > root.val;
            mx = Math.max(mx, rMx);
            mi = Math.min(mi, rMi);
        }
        if (flag) {
            ans = Math.max(ans, getSum(root));
        }
        return new Pair<>(flag, new int[]{mx, mi});
    }

    private int getSum(TreeNode root) {
        if (f.containsKey(root)) {
            return f.get(root);
        }
        if (root == null) {
            return 0;
        }
        int l = getSum(root.left), r = getSum(root.right);
        f.put(root, l + r + root.val);
        return f.get(root);
    }
}
