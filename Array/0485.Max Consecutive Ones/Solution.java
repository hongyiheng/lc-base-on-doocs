class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0, right = 0, res = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                res = Math.max(res, right - left);
                left = right + 1;
            }
            right++;
        }
        res = Math.max(res, right - left);
        return res;
    }
}