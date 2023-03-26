class Solution {
    public int findClosestNumber(int[] nums) {
        int ans = nums[0], gap = Math.abs(nums[0]);
        for (int v : nums) {
            if (Math.abs(v) < gap) {
                gap = Math.abs(v);
                ans = v;
            } else if (Math.abs(v) == gap && v > ans) {
                ans = v;
            }
        }
        return ans;
    }
}