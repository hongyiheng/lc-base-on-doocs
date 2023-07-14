class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] < 0) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (nums[r] < 0) {
            return n;
        }
        while (r < n && nums[r] == 0) {
            r++;
        }
        return Math.max(l, n - r);
    }
}