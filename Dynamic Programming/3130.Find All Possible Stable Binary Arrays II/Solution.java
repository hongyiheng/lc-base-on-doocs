class Solution {

    long[][][] f;
    int limit, MOD;

    public Long dfs(int i, int j, int k) {
        if (f[i][j][k] != -1) {
            return f[i][j][k];
        }
        if (i == 0) {
            return k == 1 && j <= limit ? 1L : 0L;
        }
        if (j == 0) {
            return k == 0 && i <= limit ? 1L : 0L;
        }
        long ans = 0;
        if (k == 0) {
            ans = (dfs(i - 1, j, 0) % MOD + dfs(i - 1, j, 1) % MOD - (i > limit ? dfs(i - limit - 1, j, 1) : 0) % MOD + MOD) % MOD;
        } else {
            ans = (dfs(i, j - 1, 0) % MOD + dfs(i, j - 1, 1) % MOD - (j > limit ? dfs(i, j - limit - 1, 0) : 0) % MOD + MOD) % MOD;
        }
        f[i][j][k] = ans;
        return ans;
    }

    public int numberOfStableArrays(int zero, int one, int limit) {
        this.limit = limit;
        f = new long[zero + 1][one + 1][2];
        for (long[][] arr : f) {
            for (long[] row : arr) {
                Arrays.fill(row, -1);
            }
        }
        MOD = (int) 1e9 + 7;
        return (int)((dfs(zero, one, 0) + dfs(zero, one, 1) + MOD) % MOD);
    }
}