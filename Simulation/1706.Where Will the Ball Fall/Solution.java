class Solution {

    int m, n;

    public int dfs(int[][] grid, int x, int y) {
        if (x >= m) {
            return y;
        }
        if (y < n - 1 && grid[x][y] == 1 && grid[x][y + 1] == 1) {
            return dfs(grid, x + 1, y + 1);
        } else if (y > 0 && grid[x][y] == -1 && grid[x][y - 1] == -1) {
            return dfs(grid, x + 1, y - 1);
        }
        return -1;
    }

    public int[] findBall(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = dfs(grid, 0, i);
        }
        return ans;
    }
}