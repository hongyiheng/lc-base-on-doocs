class Solution {
    boolean[][] visit;
    int[][] grid;
    int cur, color, m, n;
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        m = grid.length;
        n = grid[0].length;
        visit = new boolean[m][n];
        this.grid = grid;
        cur = grid[row][col];
        this.color = color;
        dfs(row, col, row, col);
        return grid;
    }

    private void dfs(int x, int y, int ox, int oy) {
        if (0 <= x && x < m && 0 <= y && y < n) {
            if (!visit[x][y]) {
                if (grid[x][y] == cur) {
                    visit[x][y] = true;
                    dfs(x + 1, y, x, y);
                    dfs(x - 1, y, x, y);
                    dfs(x, y - 1, x, y);
                    dfs(x, y + 1, x, y);
                } else {
                    grid[ox][oy] = color;
                }
            }
        } else {
            grid[ox][oy] = color;
        }
    }
}