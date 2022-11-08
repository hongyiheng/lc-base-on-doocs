class Solution {
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        int[][] nc = new int[n][2];
        for (int i = 0; i < n; i++) {
            nc[i][0] = nums[i];
            nc[i][1] = cost[i];
        }
        Arrays.sort(nc, (a, b) -> a[0] - b[0]);
        long ans = 0, cur = 0, left = 0, right = 0;
        for (int[] v : nc) {
            cur += 1L * (v[0] - nc[0][0]) * v[1];
            right += v[1];
        }
        ans = cur;
        for (int i = 1; i < n; i++) {
            left += nc[i - 1][1];
            right -= nc[i - 1][1];
            long diff = nc[i][0] - nc[i - 1][0];
            cur += left * diff - right * diff;
            ans = Math.min(ans, cur);
        }
        return ans;
    }
}
