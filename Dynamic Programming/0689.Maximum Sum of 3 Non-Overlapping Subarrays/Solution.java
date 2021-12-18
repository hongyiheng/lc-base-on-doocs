class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] pre = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }
        int[][] dp = new int[n + 1][4];
        for (int i = k; i < n + 1; i++) {
            int s = pre[i] - pre[i - k];
            for (int j = 1; j < 4; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - k][j - 1] + s);
            }
        }
        int[] ans = new int[3];
        int index = n;
        for (int i = 2; i >= 0; i--) {
            while (dp[index - 1][i + 1] >= dp[index][i + 1]) {
                index--;
            }
            ans[i] = index - k;
            index -= k;
        }
        return ans;
    }
}