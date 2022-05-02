class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        int ans = -1, n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] < k) {
                    ans = Math.max(ans, nums[i] + nums[j]);
                }
            }
        }
        return ans;
    }
}