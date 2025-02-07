class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int[][] ds = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, - 1}};
        int x = 0, y = -1, v = 1;
        while (v <= n * n) {
            for (int[] d : ds) {
                int nx = x + d[0], ny = y + d[1];
                boolean f = false;
                while (0 <= nx && nx < n && 0 <= ny && ny < n && ans[nx][ny] == 0) {
                    f = true;
                    ans[nx][ny] = v++;
                    nx += d[0];
                    ny += d[1];
                }
                if (f) {
                    x = nx - d[0];
                    y = ny - d[1];
                    break;
                }
            }
        }
        return ans;
    }
}