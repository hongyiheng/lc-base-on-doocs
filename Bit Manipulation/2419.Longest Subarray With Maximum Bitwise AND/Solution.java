class Solution {
    public int longestSubarray(int[] nums) {
        int mx = 0, cur = 0, ans = 0;
        for (int v : nums) {
            if (v > mx) {
                cur = 1;
                ans = 1;
                mx = v;
            } else if (v == mx) {
                cur++;
            } else {
                cur = 0;
            }
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}
