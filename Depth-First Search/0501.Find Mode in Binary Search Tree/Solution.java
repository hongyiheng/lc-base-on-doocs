class Solution {
    List<Integer> ans = new ArrayList<>();
    int cur, count, maxCount;

    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] res = new int[ans.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        handle(root.val);
        dfs(root.right);
    }

    public void handle(Integer val) {
        if (val == cur) {
            count++;
        } else {
            cur = val;
            count = 1;
        }
        if (count == maxCount) {
            ans.add(cur);
        }
        if (count > maxCount) {
            maxCount = count;
            ans.clear();
            ans.add(cur);
        }
    }
}