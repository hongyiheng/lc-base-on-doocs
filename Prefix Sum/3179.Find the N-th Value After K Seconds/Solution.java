class Solution {
    public int valueAfterKSeconds(int n, int k) {
        int mod = (int)1e9 + 7;
        long[][] f = new long[k + 1][n];
        f[0][0] = 1;
        for (int i = 0; i < k + 1; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) {
                    f[i][j] = f[i - 1][j];
                }
                if (j > 0) {
                    f[i][j] = (f[i][j] + f[i][j - 1]) % mod;
                }
            }
        }
        return (int)f[k][n - 1];
    }
}