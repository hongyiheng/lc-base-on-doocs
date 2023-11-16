class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int l = 0, ans = 0, n = nums.length;
        while (l < n) {
            if (nums[l] % 2 != 0 || nums[l] > threshold) {
                l++;
                continue;
            }
            int r = l + 1;
            while (r < n) {
                if (nums[r] > threshold || nums[r - 1] % 2 == nums[r] % 2) {
                    break;
                }
                r++;
            }
            ans = Math.max(ans, r - l);
            l = r;
        }
        return ans;
    }
}