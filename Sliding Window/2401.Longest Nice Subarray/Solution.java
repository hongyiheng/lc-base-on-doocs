class Solution {
    public int longestNiceSubarray(int[] nums) {
        int l = 0, r = 0, ans = 0, msk = 0;
        while (r < nums.length) {
            while ((msk & nums[r]) != 0) {
                msk ^= nums[l++];
            }
            msk |= nums[r];
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}