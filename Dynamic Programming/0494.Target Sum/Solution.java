class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int s = 0;
        for (int v : nums) {
            s += Math.abs(v);
        }
        if (Math.abs(target) > s) {
            return 0;
        }
        int[][] f = new int[n + 1][2 * s + 1];
        f[0][s] = 1;
        for (int i = 1; i <= n; i++) {
            int cur = nums[i - 1];
            for (int j = -s; j <= s; j++) {
                if (j - cur + s >= 0) {
                    f[i][j + s] += f[i - 1][j - cur + s];
                }
                if (j + cur + s <= 2 * s) {
                    f[i][j + s] += f[i - 1][j + cur + s];
                }
            }
        }
        return f[n][s + target];
    }
}