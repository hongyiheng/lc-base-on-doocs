/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer, List<Integer>> edges = new HashMap<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.pollLast();
            if (cur.left != null) {
                edges.computeIfAbsent(cur.val, e -> new ArrayList<>()).add(cur.left.val);
                edges.computeIfAbsent(cur.left.val, e -> new ArrayList<>()).add(cur.val);
                q.addLast(cur.left);
            }
            if (cur.right != null) {
                edges.computeIfAbsent(cur.val, e -> new ArrayList<>()).add(cur.right.val);
                edges.computeIfAbsent(cur.right.val, e -> new ArrayList<>()).add(cur.val);
                q.addLast(cur.right);
            }
        }
        Deque<Integer> q2 = new ArrayDeque<>();
        q2.addLast(target.val);
        Set<Integer> vis = new HashSet<>();
        vis.add(target.val);
        List<Integer> ans = new ArrayList<>();
        while (!q2.isEmpty()) {
            int m = q2.size();
            for (int i = 0; i < m; i++) {
                int cur = q2.pollFirst();
                if (k == 0) {
                    ans.add(cur);
                    continue;
                }
                for (int to : edges.getOrDefault(cur, new ArrayList<>())) {
                    if (vis.contains(to)) {
                        continue;
                    }
                    vis.add(to);
                    q2.addLast(to);
                }
            }
            k--;
        }
        return ans;
    }
}