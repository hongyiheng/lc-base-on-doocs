class Solution {
    public boolean satisfiesConditions(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && grid[i][j] != grid[i - 1][j]) {
                    return false;
                }
                if (j > 0 && grid[i][j] == grid[i][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}