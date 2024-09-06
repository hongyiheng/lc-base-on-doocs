class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int[][] f = new int[n][k + 1];
        for (int[] r : f) {
            Arrays.fill(r, 1);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int d = 0; d < k + 1; d++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] == nums[j]) {
                        f[i][d] = Math.max(f[i][d], f[j][d] + 1);
                    } else if (d > 0) {
                        f[i][d] = Math.max(f[i][d], f[j][d - 1] + 1);
                    }
                }
                ans = Math.max(ans, f[i][d]);
            }
        }
        return ans;
    }
}