class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double[] pre = new double[n + 10];
        for (int i = 1; i < n + 1; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }
        double[][] f = new double[n + 10][k + 10];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < Math.min(i, k) + 1; j++) {
                if (j == 1) {
                    f[i][j] = pre[i] / i;
                    continue;
                }
                for (int t = 2; t < i + 1; t++) {
                    f[i][j] = Math.max(f[i][j], f[t - 1][j - 1] + (pre[i] - pre[t - 1]) / (i - t + 1));
                }
            }
        }
        return f[n][k];
    }
}
