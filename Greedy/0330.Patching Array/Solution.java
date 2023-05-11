class Solution {
    public int minPatches(int[] nums, int n) {
        long cur = 1;
        int ans = 0, idx = 0;
        while (cur <= n) {
            if (idx < nums.length && nums[idx] <= cur) {
                cur += nums[idx++];
            } else {
                cur <<= 1;
                ans++;
            }
        }
        return ans;
    }
}
