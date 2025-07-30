class Solution {
    public int longestSubarray(int[] nums) {
        int ans = 0, cnt = 0, mx = nums[0];
        for (int v : nums) {
            if (v == mx) {
                cnt++;
            } else if (v > mx) {
                mx = v;
                cnt = 1;
                ans = 0;
            } else {
                cnt = 0;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}