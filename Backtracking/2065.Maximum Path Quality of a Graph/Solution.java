class Solution {

    int maxTime;
    int[] values;
    Map<Integer, List<int[]>> g;
    boolean[] vis;
    int ans;

    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        this.maxTime = maxTime;
        this.values = values;
        this.g = new HashMap<>();
        this.vis = new boolean[values.length];
        this.ans = 0;
        for (int[] e : edges) {
            int u = e[0], v = e[1], t = e[2];
            g.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[]{v, t});
            g.computeIfAbsent(v, k -> new ArrayList<>()).add(new int[]{u, t});
        }
        vis[0] = true;
        dfs(0, 0, values[0]);
        return ans;
    }

    private void dfs(int u, int ts, int vs) {
        if (ts > maxTime) {
            return;
        }
        if (u == 0) {
            ans = Math.max(ans, vs);
        }
        for (int[] neighbor : g.getOrDefault(u, new ArrayList<>())) {
            int v = neighbor[0];
            int t = neighbor[1];
            if (vis[v]) {
                dfs(v, ts + t, vs);
            }
            if (!vis[v]) {
                vis[v] = true;
                dfs(v, ts + t, vs + values[v]);
                vis[v] = false;
            }
        }
    }
}