/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        return new StringBuilder()
                .append(root.val)
                .append(",")
                .append(serialize(root.left))
                .append(",")
                .append(serialize(root.right))
                .toString();
    }

    // Decodes your encoded data to tree.
    Deque<String> q;

    public TreeNode deserialize(String data) {
        q = new ArrayDeque<>();
        for (String v : data.split(",")) {
            q.offer(v);
        }
        return buildTree(q);
    }

    public TreeNode buildTree(Deque<String> q) {
        if (q.isEmpty() || ("#").equals(q.peekFirst())) {
            q.pollFirst();
            return null;
        }
        TreeNode ans = new TreeNode(Integer.parseInt(q.pollFirst()));
        ans.left = buildTree(q);
        ans.right = buildTree(q);
        return ans;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;