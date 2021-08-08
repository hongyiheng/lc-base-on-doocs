class Solution {
    public int longestOnes(int[] nums, int k) {
        int res = 0;
        int left = 0, right = 0;
        int zeros = 0;
        while (right < nums.length) {
            if (nums[right] == 0)
                zeros++;
            while (zeros > k) {
                if (nums[left++] == 0) {
                    zeros--;
                }
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}