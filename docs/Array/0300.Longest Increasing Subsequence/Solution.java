class Solution {
    int[] dp;
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            int lastMax = getLastMax(nums, i);
            dp[i] = lastMax + 1;
        }
        int ans = 0;
        for (int num : dp) {
            ans = Math.max(num, ans);
        }
        return ans;
    }

    private int getLastMax(int[] nums, int index) {
        int cur = nums[index];
        int ans = 0;
        for (int i = index - 1; i >= 0; i--) {
            if (nums[i] < cur) {
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }
}