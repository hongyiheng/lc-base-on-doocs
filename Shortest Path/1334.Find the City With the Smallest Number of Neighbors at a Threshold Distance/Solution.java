class Solution {

    final int inf = 0x3f3f3f3f;

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] g = new int[n][n];
        for (int[] row : g) {
            Arrays.fill(row, inf);
        }
        for (int[] e : edges) {
            int u = e[0], v = e[1], d = e[2];
            g[u][v] = d;
            g[v][u] = d;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (g[i][k] >= inf || g[k][j] >= inf) {
                        continue;
                    }
                    g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                    g[j][i] = g[i][j];
                }
            }
        }
        int mi = inf, ans = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (g[i][j] <= distanceThreshold) {
                    cnt++;
                }
            }
            if (cnt <= mi) {
                mi = cnt;
                ans = i;
            }
        }
        return ans;
    }
}