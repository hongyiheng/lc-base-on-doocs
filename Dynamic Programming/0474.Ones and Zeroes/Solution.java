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
        int[][] dp = new int[m + 1][n + 1];
        for (int k = 0; k < len; k++) {
            int zero = cnt[k][0], one = cnt[k][1];
            for (int i = m; i >= zero; i--) {
                for (int j = n; j >= one; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
                }
            }
        }
        return dp[m][n];
    }
}