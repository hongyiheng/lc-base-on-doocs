class Solution {
    public int maximumLength(int[] nums, int k) {
        int[][] f = new int[k][k];
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i] % k;
            for (int j = 0; j < k; j++) {
                f[j][x] = Math.max(f[j][x], f[x][j] + 1);
                ans = Math.max(ans, f[j][x]);
            }
        }
        return ans;
    }
}