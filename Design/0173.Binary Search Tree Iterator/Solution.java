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
class BSTIterator {

    List<Integer> q;
    int idx;

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        q.add(root.val);
        dfs(root.right);
    }

    public BSTIterator(TreeNode root) {
        q = new ArrayList<>();
        dfs(root);
        idx = 0;
    }

    public int next() {
        return q.get(idx++);
    }

    public boolean hasNext() {
        return idx < q.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */