class Solution {
    public int rearrangeSticks(int n, int k) {
        int mod = (int)1e9 + 7;
        int[][] f = new int[n + 1][k + 1];
        f[0][0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < k + 1; j++) {
                f[i][j] = f[i - 1][j - 1];
                if (i - 1 >= j) {
                    f[i][j] = (int)((f[i][j] + 1L * (i - 1) * f[i - 1][j]) % mod);
                }
            }
        }
        return f[n][k];
    }
}