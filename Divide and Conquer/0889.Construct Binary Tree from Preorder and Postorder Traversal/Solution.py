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

    public int indexOf(int[] arr, int v) {
        for (int i = 0; i < arr.length; i++) {
            if (v == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        if (n == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        if (n > 1) {
            int leftSize = indexOf(postorder, preorder[1]) + 1;
            int[] pre1 = Arrays.copyOfRange(preorder, 1, leftSize + 1);
            int[] pre2 = Arrays.copyOfRange(preorder, leftSize + 1, n);
            int[] post1 = Arrays.copyOfRange(postorder, 0, leftSize);
            int[] post2 = Arrays.copyOfRange(postorder, leftSize, n - 1);
            root.left = constructFromPrePost(pre1, post1);
            root.right = constructFromPrePost(pre2, post2);
        }
        return root;
    }
}