class Solution {
    int depth = 0;
    int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }

    public void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        dfs(root.left, k);
        depth++;
        if (depth == k) {
            res = root.val;
            return;
        }
        dfs(root.right, k);
    }
}