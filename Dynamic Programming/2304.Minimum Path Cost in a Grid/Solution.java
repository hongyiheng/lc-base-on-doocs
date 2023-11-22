class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int inf = 0x3f3f3f3f;
        int m = grid.length, n = grid[0].length;
        int[][] f = new int[m][n];
        for (int[] row : f) {
            Arrays.fill(row, inf);
        }
        for (int j = 0; j < n; j++) {
            f[0][j] = grid[0][j];
        }
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                int v = grid[i][j];
                for (int k = 0; k < n; k++) {
                    f[i + 1][k] = Math.min(f[i + 1][k], f[i][j] + moveCost[v][k] + grid[i + 1][k]);
                }
            }
        }
        return Arrays.stream(f[m - 1]).min().getAsInt();
    }
}