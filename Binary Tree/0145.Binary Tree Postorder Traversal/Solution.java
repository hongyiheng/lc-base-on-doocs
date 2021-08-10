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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode pre;
        while (root != null) {
            if (root.right == null) {
                res.add(root.val);
                root = root.left;
            } else {
                pre = root.right;
                while (pre.left != null && pre.left != root) {
                    pre = pre.left;
                }
                if (pre.left == null) {
                    res.add(root.val);
                    pre.left = root;
                    root = root.right;
                } else {
                    root = root.left;
                    pre.left = null;
                }
            }
        }
        Collections.reverse(res);
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
        postorder(tree.right, res);
        res.add(tree.val);
    }
}