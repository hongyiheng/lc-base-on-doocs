class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length, n = coins[0].length;
        int[][][] f = new int[m + 1][n + 1][3];
        for (int[][] row : f) {
            for (int[] r : row) {
                Arrays.fill(r, -0x3f3f3f);
            }
        }
        f[1][0] = new int[3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = coins[i][j];
                f[i + 1][j + 1][0] = Math.max(f[i + 1][j][0], f[i][j + 1][0]) + x;
                f[i + 1][j + 1][1] = Math.max(Math.max(f[i + 1][j][0], f[i][j + 1][0]), Math.max(f[i + 1][j][1], f[i][j + 1][1]) + x);
                f[i + 1][j + 1][2] = Math.max(Math.max(f[i + 1][j][1], f[i][j + 1][1]), Math.max(f[i + 1][j][2], f[i][j + 1][2]) + x);
            }
        }
        return f[m][n][2];
    }
}