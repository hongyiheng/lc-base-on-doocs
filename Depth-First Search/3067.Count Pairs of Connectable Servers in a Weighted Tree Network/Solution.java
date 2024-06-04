class Solution {

    Map<Integer, List<int[]>> g;
    int signalSpeed;

    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        g = new HashMap<>();
        this.signalSpeed = signalSpeed;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            g.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[]{v, w});
            g.computeIfAbsent(v, k -> new ArrayList<>()).add(new int[]{u, w});
        }

        int n = edges.length;
        int[] ans = new int[n + 1];
        for (int u = 0; u <= n; u++) {
            int s = 0;
            for (int[] vw : g.getOrDefault(u, new ArrayList<>())) {
                int v = vw[0];
                int w = vw[1];
                int t = dfs(v, u, w);
                ans[u] += s * t;
                s += t;
            }
        }
        return ans;
    }

    private int dfs(int u, int p, int w) {
        int ans = w % signalSpeed == 0 ? 1 : 0;
        for (int[] e : g.getOrDefault(u, new ArrayList<>())) {
            int v = e[0];
            int vw = e[1];
            if (v != p) {
                ans += dfs(v, u, vw + w);
            }
        }
        return ans;
    }
}