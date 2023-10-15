class Solution {
    public int numberOfWays(int n, int x) {
        long[][] f = new long[n + 1][n + 1];
        f[0][0] = 1;
        long ans = 0;
        int M = (int)1e9 + 7;
        for (int i = 1; i <= n; i++) {
            int v = (int)Math.pow(i, x);
            if (v > n) {
                continue;
            }
            for (int j = 0; j <= n; j++) {
                f[i][j] = f[i - 1][j];
                if (v <= j) {
                    f[i][j] = (f[i][j] + f[i - 1][j - v]) % M;
                }
            }
            ans = f[i][n];
        }
        return (int)ans;
    }
}