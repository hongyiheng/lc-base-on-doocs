class Solution {
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (i < n / 2) {
                ans += Math.max(nums[i] - k, 0);
            } else if (i == n / 2) {
                ans += Math.abs(nums[i] - k);
            } else {
                ans += Math.max(k - nums[i], 0);
            }
        }
        return ans;
    }
}