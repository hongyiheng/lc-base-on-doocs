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

// morris
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode pre;
        while (root != null) {
            if(root.left == null) {
                res.add(root.val);
                root = root.right;
            }else {
                pre = root.left;
                while (pre.right != null && pre.right != root) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = root;
                    root = root.left;
                }else {
                    res.add(root.val);
                    pre.right = null;
                    root = root.right;
                }
            }

        }
        return res;
    }
}

// 迭代
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    public void postorder(TreeNode tree, List<Integer> res) {
        if(tree == null) {
            return;
        }
        postorder(tree.left, res);
        res.add(tree.val);
        postorder(tree.right, res);
    }
}