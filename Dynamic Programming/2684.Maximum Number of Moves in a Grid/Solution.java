class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] f = new int[m][n];
        for (int[] r : f) {
            Arrays.fill(r, Integer.MAX_VALUE);
        }
        for (int i = 0; i < m; i++) {
            f[i][0] = grid[i][0];
        }
        int ans = 0;
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < m; i++) {
                int v = f[i][j - 1];
                if (i > 0) {
                    v = Math.min(v, f[i - 1][j - 1]);
                }
                if (i < m - 1) {
                    v = Math.min(v, f[i + 1][j - 1]);
                }
                if (grid[i][j] > v) {
                    f[i][j] =  grid[i][j];
                    ans = j;
                }
            }
        }
        return ans;
    }
}