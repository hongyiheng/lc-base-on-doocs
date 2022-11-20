class Solution {
    public int maxSum(int[][] grid) {
        int ans = 0, m = grid.length, n = grid[0].length;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                int cur = grid[i - 1][j - 1] + grid[i - 1][j] + grid[i - 1][j + 1] + grid[i][j] + grid[i + 1][j - 1] + grid[i + 1][j] + grid[i + 1][j + 1];
                ans = Math.max(ans, cur);
            }
        }
        return ans;
    }
}
