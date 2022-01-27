class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[][] dp1 = new int[n + 1][2];
        for (int i = 1; i < n; i++) {
            dp1[i][0] = Math.max(dp1[i - 1][0], dp1[i - 1][1]);
            dp1[i][1] = dp1[i - 1][0] + nums[i - 1];
        }
        int[][] dp2 = new int[n + 1][2];
        for (int i = 2; i < n + 1; i++) {
            dp2[i][0] = Math.max(dp2[i - 1][0], dp2[i - 1][1]);
            dp2[i][1] = dp2[i - 1][0] + nums[i - 1];
        }
        return Math.max(Math.max(dp1[n - 1][0], dp1[n - 1][1]), Math.max(dp2[n][0], dp2[n][1]));
    }
}