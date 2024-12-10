class Solution {
    public int knightDialer(int n) {
        int mod = (int)1e9 + 7;
        long[][] f = new long[n + 1][10];
        Arrays.fill(f[1], 1);
        for (int i = 2; i < n + 1; i++) {
            f[i][0] = (f[i - 1][4] + f[i - 1][6]) % mod;
            f[i][1] = (f[i - 1][8] + f[i - 1][6]) % mod;
            f[i][2] = (f[i - 1][7] + f[i - 1][9]) % mod;
            f[i][3] = (f[i - 1][4] + f[i - 1][8]) % mod;
            f[i][4] = (f[i - 1][0] + f[i - 1][3] + f[i - 1][9]) % mod;
            f[i][6] = (f[i - 1][0] + f[i - 1][1] + f[i - 1][7]) % mod;
            f[i][7] = (f[i - 1][2] + f[i - 1][6]) % mod;
            f[i][8] = (f[i - 1][1] + f[i - 1][3]) % mod;
            f[i][9] = (f[i - 1][4] + f[i - 1][2]) % mod;
        }
        long ans = 0;
        for (long v : f[n]) {
            ans = (ans + v) % mod;
        }
        return (int)(ans % mod);
    }
}