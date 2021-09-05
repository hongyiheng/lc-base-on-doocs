class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int inLeft, int inRight, int[] postorder, int postLeft, int postRight) {
        //终止条件
        if (inLeft > inRight || postLeft > postRight) {
            return null;
        }
        //从后序遍历中拿到根节点
        int root = postorder[postRight];
        //从中序取出根节点的索引
        int index = map.get(root);
        //构建根节点
        TreeNode tree = new TreeNode(root);
        tree.left = buildTree(inLeft, index - 1, postorder, postLeft, postRight - inRight + index - 1);
        tree.right = buildTree(index + 1, inRight, postorder, postRight - inRight + index, postRight - 1);
        return tree;

    }