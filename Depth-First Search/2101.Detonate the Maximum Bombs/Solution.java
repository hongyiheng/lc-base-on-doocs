class Solution {
    int n;
    long[][] g;
    int[][] bombs;

    public int dfs(int u, int r, Set<Integer> vis) {
        int ans = 1;
        for (int v = 0; v < n; v++) {
            if (g[u][v] > (long)r * r || vis.contains(v)) {
                continue;
            }
            vis.add(v);
            ans += dfs(v, bombs[v][2], vis);
        }
        return ans;
    }


    public int maximumDetonation(int[][] bombs) {
        n = bombs.length;
        g = new long[n][n];
        this.bombs = bombs;
        for (long[] row : g) {
            Arrays.fill(row, Long.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x = bombs[i][0] - bombs[j][0];
                int y = bombs[i][1] - bombs[j][1];
                g[i][j] = g[j][i] = (long)x * x + (long)y * y;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(i, bombs[i][2], new HashSet<>(Arrays.asList(i))));
        }
        return ans;
    }
}