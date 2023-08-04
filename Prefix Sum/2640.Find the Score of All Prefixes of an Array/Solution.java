class Solution {
    public long[] findPrefixScore(int[] nums) {
        int n = nums.length, mx = nums[0];
        long[] ans = new long[n];
        ans[0] = nums[0] * 2;
        for (int i = 1; i < n; i++) {
            mx = Math.max(mx, nums[i]);
            ans[i] = ans[i - 1] + nums[i] + mx;
        }
        return ans;
    }
}