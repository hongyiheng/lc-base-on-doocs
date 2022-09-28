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
class CBTInserter {
    List<TreeNode> tr = new ArrayList<>();
    int idx = 0;

    public CBTInserter(TreeNode root) {
        int cur = 0;
        tr.add(root);
        while (cur < tr.size()) {
            TreeNode node = tr.get(cur);
            if (node.left != null) {
                tr.add(node.left);
            }
            if (node.right != null) {
                tr.add(node.right);
            }
            cur++;
        }
    }

    public int insert(int val) {
        while (tr.get(idx).left != null && tr.get(idx).right != null) {
            idx++;
        }
        TreeNode node = new TreeNode(val);
        if (tr.get(idx).left == null) {
            tr.get(idx).left = node;
        } else {
            tr.get(idx).right = node;
        }
        tr.add(node);
        return tr.get(idx).val;
    }

    public TreeNode get_root() {
        return tr.get(0);
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */
