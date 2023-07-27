class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int m = grid.length, n = grid[0].length, ans = 0;
        for (int[] row : grid) {
            Arrays.sort(row);
        }
        for (int j = 0; j < n; j++) {
            int mx = grid[0][j];
            for (int i = 1; i < m; i++) {
                mx = Math.max(mx, grid[i][j]);
            }
            ans += mx;
        }
        return ans;
    }
}