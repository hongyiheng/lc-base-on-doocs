class Solution {

    public boolean check(int n, int[][] roads, int maxDistance, int mask) {
        int[][] f = new int[n][n];
        for (int[] row : f) {
            Arrays.fill(row, 0x3f3f3f3f);
        }
        for (int[] e : roads) {
            int u = e[0], v = e[1], w = e[2];
            if ((mask >> u & 1) == 0 || (mask >> v & 1) == 0) {
                continue;
            }
            f[u][v] = f[v][u] = Math.min(f[u][v], w);
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    f[i][j] = f[j][i] = Math.min(f[i][j], f[i][k] + f[k][j]);
                }
            }
        }
        for (int u = 0; u < n; u++) {
            for (int v = u + 1; v < n; v++) {
                if ((mask >> u & 1) == 0 || (mask >> v & 1) == 0) {
                    continue;
                }
                if (f[u][v] > maxDistance) {
                    return false;
                }
            }
        }
        return true;
    }

    public int numberOfSets(int n, int maxDistance, int[][] roads) {
        int ans = 0;
        for (int mask = 0; mask < 1 << n; mask++) {
            if (check(n, roads, maxDistance, mask)) {
                ans++;
            }
        }
        return ans;
    }
}