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
            List<String> ans = new ArrayList<>();
            ans.add(String.valueOf(root.val));
            ans.add(serialize(root.left));
            ans.add(serialize(root.right));
            return String.join(",", ans);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            List<String> q = Arrays.stream(data.split(",")).collect(Collectors.toList());
            return dfs(new ArrayDeque<>(q));
        }

        public TreeNode dfs(Deque<String> q) {
            String val = q.pollFirst();
            if ("#".equals(val)) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(val));
            root.left = dfs(q);
            root.right = dfs(q);
            return root;
        }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
