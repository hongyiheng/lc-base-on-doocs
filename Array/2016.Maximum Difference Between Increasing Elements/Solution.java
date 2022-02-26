class Solution {
    public int maximumDifference(int[] nums) {
        int last = -1, n = nums.length;
        int ans = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (last <= nums[i]) {
                last = nums[i];
            } else {
                ans = Math.max(ans, last - nums[i]);
            }
        }
        return ans;
    }
}