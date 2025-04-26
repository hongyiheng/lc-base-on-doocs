class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int l = -1, mi = -1, mx = -1;
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            if (v < minK || maxK < v) {
                l = i;
            }
            if (v == minK) {
                mi = i;
            }
            if (v == maxK) {
                mx = i;
            }
            ans += Math.max(0, Math.min(mi, mx) - l);
        }
        return ans;
    }
}