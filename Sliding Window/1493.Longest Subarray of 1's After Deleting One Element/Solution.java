class Solution {
    public int longestSubarray(int[] nums) {
        int ans = 0, s = 0;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            s += (nums[r] & 1);
            while (l < r && s <= r - l - 1) {
                s -= (nums[l++] & 1);
            }
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
}