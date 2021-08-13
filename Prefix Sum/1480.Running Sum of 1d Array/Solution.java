class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] presum = new int[n];
        presum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            presum[i] = presum[i - 1] + nums[i];
        }
        return presum;
    }
}