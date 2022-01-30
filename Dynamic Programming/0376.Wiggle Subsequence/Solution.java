class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i][1] = dp[i - 1][0] + 1;
            } else {
                dp[i][1] = dp[i - 1][1];
            }
            if (nums[i] < nums[i - 1]) {
                dp[i][0] = dp[i - 1][1] + 1;
            } else {
                dp[i][0] = dp[i - 1][0];
            }
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}