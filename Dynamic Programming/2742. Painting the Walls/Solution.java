class Solution {

    int n;
    Map<String, Integer> f;
    int[] cost, time;

    public int dfs(int i, int t) {
        String key = i + ":" + t;
        if (f.containsKey(key)) {
            return f.get(key);
        }
        if (t >= n - i) {
            return 0;
        }
        if (i == n) {
            return 0x3f3f3f3f;
        }
        int ans = Math.min(dfs(i + 1, t + time[i]) + cost[i], dfs(i + 1, t - 1));
        f.put(key, ans);
        return ans;
    }

    public int paintWalls(int[] cost, int[] time) {
        f = new HashMap<>();
        this.cost = cost;
        this.time = time;
        n = cost.length;
        return dfs(0, 0);
    }
}