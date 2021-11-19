class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = 0;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int index = nums[i];
            if (index > nums.length) {
                index -= (nums.length + 1);
            }
            if (index == 0 || nums[index - 1] > nums.length) {
                continue;
            }
            nums[index - 1] += nums.length + 1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= nums.length) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}