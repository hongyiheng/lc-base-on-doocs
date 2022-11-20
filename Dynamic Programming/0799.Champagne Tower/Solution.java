class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[100][100];
        dp[0][0] = poured;
        for (int i = 1; i < 100; i++) {
            for (int j = 0; j < 99; j++) {
                double v = dp[i - 1][j] - 1;
                if (v > 0) {
                    dp[i][j] += v / 2;
                    dp[i][j + 1] += v / 2;
                    dp[i - 1][j] = 1;
                }
            }
        }
        return dp[query_row][query_glass];
    }
}
