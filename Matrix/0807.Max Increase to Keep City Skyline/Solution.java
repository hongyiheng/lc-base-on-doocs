class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int i = 0; i < m; i++) {
            int high = 0;
            for (int j = 0; j < n; j++) {
                high = Math.max(high, grid[i][j]);
            }
            rows[i] = high;
        }
        for (int j = 0; j < n; j++) {
            int high = 0;
            for (int i = 0; i < m; i++) {
                high = Math.max(high, grid[i][j]);
            }
            cols[j] = high;
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int maxHigh = Math.min(rows[i], cols[j]);
                res += maxHigh - grid[i][j];
            }
        }
        return res;
    }
}