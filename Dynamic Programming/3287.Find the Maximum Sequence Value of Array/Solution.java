class Solution {
    public int maxValue(int[] nums, int k) {
        int m = 1 << 7;
        int n = nums.length;
        boolean[][][] f = new boolean[n + 1][k + 2][m];
        f[0][0][0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                for (int x = 0; x < m; x++) {
                    if (f[i][j][x]) {
                        f[i + 1][j][x] = true;
                        f[i + 1][j + 1][x | nums[i]] = true;
                    }
                }
            }
        }

        boolean[][][] g = new boolean[n + 1][k + 2][m];
        g[n][0][0] = true;
        for (int i = n; i > 0; i--) {
            for (int j = 0; j < k + 1; j++) {
                for (int x = 0; x < m; x++) {
                    if (g[i][j][x]) {
                        g[i - 1][j][x] = true;
                        g[i - 1][j + 1][x | nums[i - 1]] = true;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = k; i < n - k + 1; i++) {
            for (int x = 0; x < m; x++) {
                if (f[i][k][x]) {
                    for (int y = 0; y < m; y++) {
                        if (g[i][k][y]) {
                            ans = Math.max(ans, x ^ y);
                        }
                    }
                }
            }
        }
        return ans;
    }
}