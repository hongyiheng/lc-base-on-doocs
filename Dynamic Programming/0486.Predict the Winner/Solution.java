class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 2][n + 2];
        for (int len = 1; len <= n; len++) {
            for (int l = 1; l + len - 1 <= n; l++) {
                int r = l + len - 1;
                int a = nums[l - 1] - dp[l + 1][r];
                int b = nums[r - 1] - dp[l][r - 1];
                dp[l][r] = Math.max(a, b);
            }
        }
        return dp[1][n] >= 0;
    }
}