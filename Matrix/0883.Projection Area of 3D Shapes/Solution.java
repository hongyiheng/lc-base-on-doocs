class Solution {
    public int projectionArea(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        int[] row = new int[m];
        int[] col = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    ans++;
                }
                row[i] = Math.max(grid[i][j], row[i]);
                col[j] = Math.max(grid[i][j], col[j]);
            }
        }
        for (int num : row) {
            ans += num;
        }
        for (int num : col) {
            ans += num;
        }
        return ans;
    }
}