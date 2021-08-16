class Solution {
    public List<List<Integer>> combine(int n, int k) {
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(path, n, res, k, 1);
        return res;
    }

    public void dfs(Deque<Integer> path, int n, List<List<Integer>> res, int k, int begin) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i <= n; i++) {
            path.addLast(i);
            dfs(path, n, res, k, i + 1);
            path.removeLast();
        }
    }

}