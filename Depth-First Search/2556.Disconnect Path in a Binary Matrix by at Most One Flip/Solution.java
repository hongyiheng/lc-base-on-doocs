class Solution {

    int m, n;
    int[][] grid;

    public boolean dfs(int x, int y) {
        if (x == m - 1 && y == n - 1) {
            return true;
        }
        grid[x][y] = 0;
        boolean ans = false;
        for (int[] d : new int[][]{{0, 1}, {1, 0}}) {
            int nx = x + d[0], ny = y + d[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                continue;
            }
            if (grid[nx][ny] == 0) {
                continue;
            }
            ans = ans || dfs(nx, ny);
        }
        return ans;
    }

    public boolean isPossibleToCutPath(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        if (grid[0][0] == 0 || grid[m - 1][n - 1] == 0) {
            return true;
        }
        return !dfs(0, 0) || !dfs(0, 0);
    }
}