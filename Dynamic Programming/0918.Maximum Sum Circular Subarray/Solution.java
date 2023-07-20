class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int inf = 0x3f3f3f3f;
        int n = nums.length, mx = -inf, mi = inf;
        int ans = 0, s = 0;
        for (int v : nums) {
            s += v;
            ans += v;
        }
        for (int i = 0; i < n; i++) {
            mx = Math.max(nums[i], mx + nums[i]);
            mi = Math.min(nums[i], mi + nums[i]);
            if (i == n - 1 && mi == s) {
                mi = inf;
            }
            ans = Math.max(ans, Math.max(s - mi, mx));
        }
        return ans;
    }
}