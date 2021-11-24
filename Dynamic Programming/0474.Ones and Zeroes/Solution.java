class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] cnt = new int[len][2];
        for (int i = 0; i < len; i++) {
            char[] chars = strs[i].toCharArray();
            int zero = 0, one = 0;
            for (char c : chars) {
                if (c == '0') {
                    zero++;
                } else {
                    one++;
                }
            }
            cnt[i][0] = zero;
            cnt[i][1] = one;
        }
        int[][][] dp = new int[len][m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[0][i][j] = i >= cnt[0][0] && j >= cnt[0][1] ? 1 : 0;
            }
        }
        for (int k = 1; k < len; k++) {
            int zero = cnt[k][0], one = cnt[k][1];
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    int a = dp[k - 1][i][j];
                    int b = i >= zero && j >= one ? dp[k - 1][i - zero][j - one] + 1 : 0;
                    dp[k][i][j] = Math.max(a, b);
                }
            }
        }
        return dp[len - 1][m][n];
    }
}