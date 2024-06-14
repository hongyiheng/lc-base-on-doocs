class Solution {
    public long maxScore(int[] nums, int x) {
        int n = nums.length;
        long[][] f = new long[n + 1][2];
        f[0][nums[0] & 1 ^ 1] = -x;
        for (int i = 1; i < n + 1; i++) {
            int v = nums[i - 1];
            f[i][0] = f[i - 1][0];
            f[i][1] = f[i - 1][1];
            f[i][v & 1] = Math.max(f[i - 1][v & 1] + v, f[i - 1][v & 1 ^ 1] - x + v);
        }
        return Math.max(f[n][0], f[n][1]);
    }
}