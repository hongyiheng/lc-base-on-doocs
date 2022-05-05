class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        long cur = 1;
        int ans = 0, left = 0;
        for (int i = 0; i < nums.length; i++) {
            cur *= nums[i];
            while (left < i && cur >= k) {
                cur /= nums[left];
                left++;
            }
            if (cur < k) {
                ans += i - left + 1;
            }
        }
        return ans;
    }
}
