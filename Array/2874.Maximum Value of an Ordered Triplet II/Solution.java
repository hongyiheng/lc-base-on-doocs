class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] q = new int[n];
        for (int i = 1; i < n; i++) {
            q[i] = Math.max(q[i - 1], nums[i - 1]);
        }
        int mx = 0;
        long ans = 0;
        for (int i = n - 2; i > -1; i--) {
            mx = Math.max(mx, nums[i + 1]);
            ans = Math.max(ans, (long)(q[i] - nums[i]) * mx);
        }
        return ans;
    }
}