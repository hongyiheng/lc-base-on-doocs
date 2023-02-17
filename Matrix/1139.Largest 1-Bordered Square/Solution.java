class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] row = new int[m][n], col = new int[m][n];
        for (int i = m - 1; i > -1; i--) {
            for (int j = n - 1; j > -1; j--) {
                if (grid[i][j] == 0) {
                    continue;
                }
                row[i][j] = j == n - 1 ? 1 : row[i][j + 1] + 1;
                col[i][j] = i == m - 1 ? 1 : col[i + 1][j] + 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                for (int k = ans; k < Math.min(m, n); k++) {
                    if (i + k >= m || j + k >= n) {
                        continue;
                    }
                    if (row[i][j] > k && row[i + k][j] > k && col[i][j] > k && col[i][j + k] > k) {
                        ans = Math.max(ans, k + 1);
                    }
                }
            }
        }
        return ans * ans;
    }
}