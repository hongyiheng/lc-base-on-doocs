class Solution {

    final int inf = 0x3f3f3f3f;

    public int[] countOfPairs(int n, int x, int y) {
        int[][] g = new int[n][n];
        for (int[] row : g) {
            Arrays.fill(row, inf);
        }
        for (int i = 0; i < n - 1; i++) {
            g[i][i + 1] = 1;
            g[i + 1][i] = 1;
        }
        g[x - 1][y - 1] = 1;
        g[y - 1][x - 1] = 1;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                    g[j][i] = g[i][j];
                }
            }
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int v = g[i][j];
                if (v >= inf) {
                    continue;
                }
                ans[v - 1] += 2;
            }
        }
        return ans;
    }
}