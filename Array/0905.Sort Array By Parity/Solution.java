class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] % 2 == 1) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                right--;
            } else {
                left++;
            }
        }
        return nums;
    }
}