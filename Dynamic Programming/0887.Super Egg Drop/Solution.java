class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];
        for (int i = 1; i < k + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1] + 1;
            }
        }
        for (int j = 1; j < n + 1; j++) {
            if (dp[k][j] >= n) {
                return j;
            }
        }
        return -1;
    }
}