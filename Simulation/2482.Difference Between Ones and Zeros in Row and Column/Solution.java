class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] row = new int[n][2], col = new int[m][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                row[i][grid[i][j]]++;
                col[j][grid[i][j]]++;
            }
        }
        int[][] diff = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                diff[i][j] = row[i][1] + col[j][1] - row[i][0] - col[j][0];
            }
        }
        return diff;
    }
}
