class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int last = nums[0], ans = nums[0];
        for (int i = 1; i < n; i++) {
            last = Math.max(nums[i], last + nums[i]);
            ans = Math.max(ans, last);
        }
        return ans;
    }
}