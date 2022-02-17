class Solution {
    double[][][] mem;
    public double knightProbability(int n, int k, int row, int column) {
        mem = new double[n][n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int m = 0; m < k + 1; m++) {
                    mem[i][j][m] = -1;
                    if (m == 0) {
                        mem[i][j][m] = 1;
                    }
                }
            }
        }
        return dfs(row, column, k, n);
    }

    public double dfs(int x, int y, int k, int n) {
        if (x < 0 || x >= n || y < 0 || y >= n) {
            return 0;
        }
        if (mem[x][y][k] != -1) {
            return mem[x][y][k];
        }
        int[][] dirs = new int[][]{{2, 1}, {1, 2}, {2, -1}, {-1, 2}, {-2, 1}, {1, -2}, {-2, -1}, {-1, -2}};
        double ans = 0;
        for (int[] dir : dirs) {
            ans += dfs(x + dir[0], y + dir[1], k - 1, n);
        }
        mem[x][y][k] = ans / 8.0;
        return mem[x][y][k];
    }
}