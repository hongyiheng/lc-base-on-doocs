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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            mp.put(inorder[i], i);
        }
        return dfs(preorder, 0, n - 1, inorder, 0, n - 1);
    }

    public TreeNode dfs(int[] preorder, int pStart, int pEnd, int[] inorder, int inStart, int inEnd) {
        if (pStart > pEnd || inStart > inEnd) {
            return null;
        }
        int rootVal = preorder[pStart];
        int rootIndex = mp.get(rootVal);
        int leftNum = rootIndex - inStart;
        TreeNode ans = new TreeNode(rootVal);
        ans.left = dfs(preorder, pStart + 1, pStart + leftNum, inorder, inStart, rootIndex - 1);
        ans.right = dfs(preorder, pStart + leftNum + 1, pEnd, inorder, rootIndex + 1, inEnd);
        return ans;
    }
}