class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        int tStart = nums[left] < target ? left + 1 : left;
        left = 0;
        right = n - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int tEnd = nums[left] > target ? left - 1 : left;
        return (tEnd - tStart + 1) * 2 > n;
    }
}