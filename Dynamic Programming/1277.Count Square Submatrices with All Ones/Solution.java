class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] f = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (matrix[i - 1][j - 1] == 1) {
                    f[i][j] = Math.min(f[i - 1][j - 1], Math.min(f[i - 1][j], f[i][j - 1])) + 1;
                    ans += f[i][j];
                }
            }
        }
        return ans;
    }
}