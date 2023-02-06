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
     public boolean evaluateTree(TreeNode root) {
         if (root == null) {
             return true;
         }
         boolean l = evaluateTree(root.left), r = evaluateTree(root.right);
         if (root.val == 2) {
             return l || r;
         } else if (root.val == 3) {
             return l && r;
         }
         return root.val == 1 ? true : false;
     }
 }
