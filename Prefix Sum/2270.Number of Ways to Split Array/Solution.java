class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long[] pre = new long[n + 1];
        long s = 0;
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
            s += nums[i];
        }
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (pre[i] >= s - pre[i]) {
                ans++;
            }
        }
        return ans;
    }
}