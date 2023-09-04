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
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    public TreeNode dfs(Deque<String> q) {
        String v = q.pollFirst();
        if ("#".equals(v)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(v));
        root.left = dfs(q);
        root.right = dfs(q);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> q = new ArrayDeque<>(Arrays.asList(data.split(",")));
        return dfs(q);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;