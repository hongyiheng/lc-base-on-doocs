class Solution {
    public long maxArrayValue(int[] nums) {
        int n = nums.length;
        long ans = nums[n - 1], last = nums[n - 1];
        for (int i = nums.length - 2; i > -1; i--) {
            if (nums[i] <= last) {
                last += nums[i];
            } else {
                last = nums[i];
            }
            ans = Math.max(ans, last);
        }
        return ans;
    }
}