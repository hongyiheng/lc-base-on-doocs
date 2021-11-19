class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int mid = sum / 2;
        int n = nums.length;
        int[][] dp = new int[n][mid + 1];
        for (int i = 0; i < mid + 1; i++) {
            dp[0][i] = i > nums[0] ? nums[0] : 0;
        }
        for (int i = 1; i < n; i++) {
            int t = nums[i];
            for (int j = 0; j < mid + 1; j++) {
                int a = dp[i - 1][j];
                int b = j >= t ? dp[i - 1][j - t] + t : 0;
                dp[i][j] = Math.max(a, b);
            }
        }
        return dp[n - 1][mid] == mid;
    }
}