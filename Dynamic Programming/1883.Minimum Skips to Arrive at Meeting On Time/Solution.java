class Solution {
    public int minSkips(int[] dist, int speed, int hoursBefore) {
        int n = dist.length;
        double[][] f = new double[n + 1][n];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(f[i], 1e9);
        }
        f[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            int d = dist[i - 1];
            for (int j = 0; j <= i; j++) {
                if (j < i) {
                    f[i][j] = Math.ceil(f[i - 1][j] + d * 1.0 / speed - 1e-9);
                }
                if (j > 0 && j < n) {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + d * 1.0 / speed);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (f[n][i] <= hoursBefore) {
                return i;
            }
        }
        return -1;
    }
}