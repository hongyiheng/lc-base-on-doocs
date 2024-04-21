class Solution {

    int k, n;
    List<List<Integer>> ans;

    public void dfs(int i, int cnt, int s, Deque<Integer> path) {
        if (i >= 10 || cnt >= k || s >= n) {
            if (cnt == k && s == n) {
                ans.add(new ArrayList<>(path));
            }
            return;
        }
        dfs(i + 1, cnt, s, path);
        path.add(i);
        dfs(i + 1, cnt + 1, s + i, path);
        path.pollLast();
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        this.n = n;
        ans = new ArrayList<>();
        dfs(1, 0, 0, new ArrayDeque<>());
        return ans;
    }
}