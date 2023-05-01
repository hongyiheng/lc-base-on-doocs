class Solution {

    Map<Integer, List<Integer>> g = new HashMap<>();
    int[] informTime;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        this.informTime = informTime;
        for (int i = 0; i < n; i++) {
            g.computeIfAbsent(manager[i], k -> new ArrayList<>()).add(i);
        }
        return dfs(headID, 0);
    }

    public int dfs(int u, int cur) {
        if (!g.containsKey(u)) {
            return cur;
        }
        int ans = 0;
        for (int v : g.get(u)) {
            ans = Math.max(ans, dfs(v, cur + informTime[u]));
        }
        return ans;
    }
}