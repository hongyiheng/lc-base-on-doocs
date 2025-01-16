class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int ans = n + 1;
        for (int i = 0; i < n; i++) {
            int s = nums[i];
            for (int j = i; j < n; j++) {
                s |= nums[j];
                if (s >= k) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }
        return ans <= n ? ans : -1;
    }
}