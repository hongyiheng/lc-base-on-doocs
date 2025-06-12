class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int d = Math.abs(nums[0] - nums[n - 1]);
        for (int i = 1; i < n; i++) {
            d = Math.max(d, Math.abs(nums[i] - nums[i - 1]));
        }
        return d;
    }
}