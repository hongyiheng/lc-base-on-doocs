class Solution {
    public int pivotIndex(int[] nums) {
        int[] preSum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = nums[i - 1] + preSum[i - 1];
        }
        for (int i = 1; i <= nums.length; i++) {
            int left = preSum[i - 1], right = preSum[nums.length] - preSum[i];
            if (left == right) {
                return i - 1;
            }
        }
        return -1;
    }
}