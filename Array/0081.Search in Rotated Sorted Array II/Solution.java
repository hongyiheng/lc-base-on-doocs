class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[l] == nums[mid]) {
                l++;
                continue;
            }
            if (nums[r] == nums[mid]) {
                r--;
                continue;
            }
            if (nums[l] < nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
        } 
        return n > 0 && nums[r] == target;
    }
}