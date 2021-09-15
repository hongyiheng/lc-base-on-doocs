class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int last = nums[0];
        int ans = last;
        for (int i = 1; i < len; i++) {
            last = Math.max(nums[i], last + nums[i]);
            ans = Math.max(ans, last);
        }
        return ans;
    }
}