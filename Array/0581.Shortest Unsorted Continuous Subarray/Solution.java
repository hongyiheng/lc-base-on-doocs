class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] sortArray = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortArray);
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] != sortArray[left]) {
                break;
            }
            left++;
        }
        while (left < right) {
            if (nums[right] != sortArray[right]) {
                break;
            }
            right--;
        }
        return left == right ? 0 : right - left + 1;
    }
}