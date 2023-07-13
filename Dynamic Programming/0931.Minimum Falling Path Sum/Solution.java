class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int v = matrix[i - 1][j];
                if (j > 0) {
                    v = Math.min(v, matrix[i - 1][j - 1]);
                }
                if (j < n - 1) {
                    v = Math.min(v, matrix[i - 1][j + 1]);
                }
                matrix[i][j] += v;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, matrix[m - 1][j]);
        }
        return ans;
    }
}