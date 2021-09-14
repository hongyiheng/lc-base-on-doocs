class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] dp = new int[max + 1];
        for (int num : nums) {
            dp[num]++;
        }
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * dp[i]);
        }
        return dp[max];
    }
}