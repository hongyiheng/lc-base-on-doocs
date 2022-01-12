class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length, ans = 1;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            int l = 1, r = i + 1;
            while (l < r) {
                int mid = (l + r) >> 1;
                if (dp[mid] >= cur) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            dp[r] = cur;
            ans = Math.max(ans, r);
        }
        return ans >= 3;
    }
}