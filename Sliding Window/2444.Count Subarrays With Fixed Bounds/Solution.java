class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int l = -1, r1 = -1, r2 = -1;
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                l = i;
            }
            if (nums[i] == minK) {
                r1 = i;
            }
            if (nums[i] == maxK) {
                r2 = i;
            }
            ans += Math.max(0, Math.min(r1, r2) - l);
        }
        return ans;
    }
}
