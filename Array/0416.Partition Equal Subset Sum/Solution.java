class Solution {
    public boolean canPartition(int[] nums) {
        int s = 0, n = nums.length;
        for (int v : nums) {
            s += v;
        }
        if (s % 2 != 0) {
            return false;
        }
        int t = s / 2;
        boolean[][] f = new boolean[n + 1][t + 1];
        f[0][0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= t; j++) {
                f[i + 1][j] = f[i][j];
                if (j >= nums[i]) {
                    f[i + 1][j] |= f[i][j - nums[i]];
                }
            }
        }
        return f[n][t];
    }
}