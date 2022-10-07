class Solution {
    public int maxAscendingSum(int[] nums) {
        int ans = 0, cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                cur += nums[i];
            } else {
                ans = Math.max(ans, cur);
                cur = nums[i];
            }
        }
        return Math.max(ans, cur);
    }
}
