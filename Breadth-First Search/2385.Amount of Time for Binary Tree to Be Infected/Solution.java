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
    Map<TreeNode, List<TreeNode>> mp;
    int t;
    Deque<TreeNode> q;
    Set<Integer> vis;

    public int amountOfTime(TreeNode root, int start) {
        mp = new HashMap<>();
        q = new ArrayDeque<>();
        vis = new HashSet<>();
        t = start;
        dfs(null, root);
        int ans = -1;
        while (!q.isEmpty()) {
            int m = q.size();
            for (int i = 0; i < m; i++) {
                TreeNode cur = q.pollFirst();
                for (TreeNode v : mp.getOrDefault(cur, new ArrayList<>())) {
                    if (vis.contains(v.val)) {
                        continue;
                    }
                    q.addLast(v);
                    vis.add(v.val);
                }
            }
            ans++;
        }
        return ans;
    }

    public void dfs(TreeNode parent, TreeNode root) {
        if (root == null) {
            return;
        }
        if (parent != null) {
            mp.computeIfAbsent(root, k -> new ArrayList<>()).add(parent);
            mp.computeIfAbsent(parent, k -> new ArrayList<>()).add(root);
        }
        if (root.val == t) {
            q.addLast(root);
            vis.add(root.val);
        }
        dfs(root, root.left);
        dfs(root, root.right);
    }
}
