class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    public void preOrder(TreeNode tree, List<Integer> res) {
        if (tree == null) {
            return;
        }
        res.add(tree.val);
        preOrder(tree.left, res);
        preOrder(tree.right, res);
    }
}