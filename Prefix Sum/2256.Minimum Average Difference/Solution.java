class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long[] pre = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }
        int ans = 0;
        long cur = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long preAvg = pre[i + 1] / (i + 1);
            long tailAvg = (n - i - 1) == 0 ? 0 : (pre[n] - pre[i + 1]) / (n - i - 1);
            long diff = Math.abs(tailAvg - preAvg);
            if (diff < cur) {
                cur = diff;
                ans = i;
            }
        }
        return ans;
    }
}