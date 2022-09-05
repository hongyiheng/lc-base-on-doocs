class Solution {
    int INF = 0x3f3f3f3f;
    public int minCost(int[] houses, int[][] cost, int m, int n, int t) {
        int[][][] f = new int[m + 1][n + 1][t + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                f[i][j][0] = INF;
            }
        }
        for (int i = 1; i <= m; i++) {
            int color = houses[i - 1];
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= t; k++) {
                    if (k > i) {
                        f[i][j][k] = INF;
                        continue;
                    }
                    if (color != 0) {
                        if (j == color) {
                            int tmp = INF;
                            for (int p = 1; p <= n; p++) {
                                if (p != j) {
                                    tmp = Math.min(tmp, f[i - 1][p][k - 1]);
                                }
                            }
                            f[i][j][k] = Math.min(f[i - 1][j][k], tmp);
                        } else {
                            f[i][j][k] = INF;
                        }
                    } else {
                        int u = cost[i - 1][j - 1];
                        int tmp = INF;
                        for (int p = 1; p <= n; p++) {
                            if (p != j) {
                                tmp = Math.min(tmp, f[i - 1][p][k - 1]);
                            }
                        }
                        f[i][j][k] = Math.min(tmp, f[i - 1][j][k]) + u;
                    }
                }
            }
        }
        int ans = INF;
        for (int i = 1; i <= n; i++) {
            ans = Math.min(ans, f[m][i][t]);
        }
        return ans == INF ? -1 : ans;
    }
}