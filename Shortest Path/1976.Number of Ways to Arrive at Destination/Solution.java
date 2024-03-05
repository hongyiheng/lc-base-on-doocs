class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD = (int)1e9 + 7;
        long INF = Long.MAX_VALUE / 2;
        long[][] g = new long[n][n];
        for (long[] row : g) {
            Arrays.fill(row, INF);
        }
        for (int[] e : roads) {
            int u = e[0], v = e[1], w = e[2];
            g[u][v] = w;
            g[v][u] = w;
        }
        long[] dist = new long[n];
        Arrays.fill(dist, INF);
        dist[0] = 0;
        long[] f = new long[n];
        f[0] = 1;
        PriorityQueue<long[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0] > 0 ? 1 : -1);
        q.add(new long[]{0, 0});
        while (!q.isEmpty()) {
            long[] cur = q.poll();
            long w = cur[0];
            int u = (int)cur[1];
            if (u == n - 1) {
                return (int)f[n - 1];
            }
            if (dist[u] < w) {
                continue;
            }
            for (int v = 0; v < n; v++) {
                long nw = g[u][v] + w;
                if (nw < dist[v]) {
                    dist[v] = nw;
                    f[v] = f[u];
                    q.add(new long[]{nw, v});
                } else if (nw == dist[v]) {
                    f[v] = (f[u] + f[v]) % MOD;
                }
            }
        }
        return (int)f[n - 1];
    }
}