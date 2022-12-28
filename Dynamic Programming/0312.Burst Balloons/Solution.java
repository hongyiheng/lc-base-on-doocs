class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = arr[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }
        int[][] f = new int[n + 2][n + 2];
        for (int m = 3; m <= n + 2; m++) {
            for (int i = 0; i < n + 2; i++) {
                int j = i + m - 1;
                if (j > n + 1) {
                    break;
                }
                for (int k = i + 1; k < j; k++) {
                    f[i][j] = Math.max(f[i][j], f[i][k] + f[k][j] + arr[i] * arr[k] * arr[j]);
                }

            }
        }
        return f[0][n + 1];
    }
}