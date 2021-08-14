class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, "", res);
        return res;
    }

    public void dfs(TreeNode root, String path, List<String> res) {
        if (root == null) {
            return;
        }
        path += root.val;
        if (root.left == null && root.right == null) {
            res.add(path);
        } else {
            path += "->";
            dfs(root.left, path, res);
            dfs(root.right, path, res);
        }
    }
}