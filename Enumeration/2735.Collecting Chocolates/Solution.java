class Solution {
    public long minCost(int[] nums, int x) {
        int n = nums.length;
        int[][] f = new int[n][n];
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long s = 1L * i * x;
            for (int j = 0; j < n; j++) {
                f[i][j] = nums[(i + j) % n];
                if (i > 0) {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j]);
                }
                s += f[i][j];
            }
            ans = Math.min(ans, s);
        }
        return ans;
    }
}