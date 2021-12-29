class Solution {
    public int countQuadruplets(int[] nums) {
        int n = nums.length;
        int[][][] dp = new int[n + 1][101][4];
        dp[0][0][0] = 1;
        for (int i = 1; i < n + 1; i++) {
            int c = nums[i - 1];
            for (int j = 0; j < 101; j++) {
                for (int k = 0; k < 4; k++) {
                    dp[i][j][k] += dp[i - 1][j][k];
                    if (k >= 1 && j >= c) {
                        dp[i][j][k] += dp[i - 1][j - c][k - 1];
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 3; i < n; i++) {
            ans += dp[i][nums[i]][3];
        }
        return ans;
    }
}