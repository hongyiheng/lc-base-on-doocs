class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] chooseFirst = new int[len - 1];
        for (int i = 0; i < len - 1; i++) {
            chooseFirst[i] = nums[i];
        }
        int[] chooseLast = new int[len - 1];
        for (int i = 1; i < len; i++) {
            chooseLast[i - 1] = nums[i];
        }
        return Math.max(handle(chooseFirst), handle(chooseLast));
    }

    public int handle(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);

        }
        return dp[len - 1];
    }
}