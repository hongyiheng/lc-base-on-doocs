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
    Map<Integer, Integer> mp = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            mp.put(inorder[i], i);
        }
        return dfs(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode dfs(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd) {
        if (iStart > iEnd || pStart > pEnd) {
            return null;
        }
        int rootVal = postorder[pEnd];
        int rootIndex = mp.get(rootVal);
        int leftNum = rootIndex - iStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = dfs(inorder, iStart, rootIndex - 1, postorder, pStart, pStart + leftNum - 1);
        root.right = dfs(inorder, rootIndex + 1, iEnd, postorder, pStart + leftNum, pEnd - 1);
        return root;
    }
}