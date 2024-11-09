class NeighborSum {

    int[][] grid;

    public NeighborSum(int[][] grid) {
        this.grid = grid;
    }

    public int adjacentSum(int value) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != value) {
                    continue;
                }
                if (i > 0) {
                    ans += grid[i - 1][j];
                }
                if (i < m - 1) {
                    ans += grid[i + 1][j];
                }
                if (j > 0) {
                    ans += grid[i][j - 1];
                }
                if (j < n - 1) {
                    ans += grid[i][j + 1];
                }
                break;
            }
        }
        return ans;
    }

    public int diagonalSum(int value) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != value) {
                    continue;
                }
                if (i > 0) {
                    if (j > 0) {
                        ans += grid[i - 1][j - 1];
                    }
                    if (j < n - 1) {
                        ans += grid[i - 1][j + 1];
                    }
                }
                if (i < m - 1) {
                    if (j > 0) {
                        ans += grid[i + 1][j - 1];
                    }
                    if (j < n - 1) {
                        ans += grid[i + 1][j + 1];
                    }
                }
                break;
            }
        }
        return ans;
    }
}

/**
 * Your NeighborSum object will be instantiated and called as such:
 * NeighborSum obj = new NeighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */