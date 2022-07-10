class Solution {
    public int maximumTop(int[] nums, int k) {
        int n = nums.length;
        if (n == 1 && k % 2 != 0) {
            return -1;
        }
        int ans = -1;
        if (n >= k) {
            for (int i = 0; i < k - 1; i++) {
                ans = Math.max(ans, nums[i]);
            }
            if (n > k) {
                ans = Math.max(ans, nums[k]);
            }
        }
        if (n < k) {
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, nums[i]);
            }
        }
        return ans;
    }
}