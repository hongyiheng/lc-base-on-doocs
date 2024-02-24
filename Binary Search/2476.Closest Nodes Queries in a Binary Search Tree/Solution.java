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
    List<Integer> q = new ArrayList<>();
    List<Integer> qs = new ArrayList<>();

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        q.add(root.val);
        dfs(root.right);
    }

    public void search(int i, int l, List<Integer> queries, List<List<Integer>> res) {
        if (i == qs.size()) {
            return;
        }
        int j = qs.get(i), t = queries.get(j), r = q.size() - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (q.get(mid) < t) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (q.get(r) <= t) {
            res.get(j).set(0, q.get(r));
        } else if (r > 0 && q.get(r - 1) <= t) {
            res.get(j).set(0, q.get(r - 1));
        }
        if (q.get(r) >= t) {
            res.get(j).set(1, q.get(r));
        }
        search(i + 1, l, queries, res);
    }

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        dfs(root);
        for (int i = 0; i < queries.size(); i++) {
            qs.add(i);
        }
        qs.sort((a, b) -> queries.get(a) - queries.get(b));
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < queries.size(); i++) {
            List<Integer> item = new ArrayList<>();
            item.add(-1);
            item.add(-1);
            res.add(item);
        }
        search(0, 0, queries, res);
        return res;
    }
}