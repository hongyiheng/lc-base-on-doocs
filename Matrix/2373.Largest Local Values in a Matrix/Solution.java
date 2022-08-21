class Solution {
    int[][] g;

    public int[][] largestLocal(int[][] grid) {
        this.g = grid;
        int n = grid.length;
        int[][] ans = new int[n - 2][n - 2];
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                ans[i - 1][j - 1] = getMax(i, j);
            }
        }
        return ans;
    }

    public int getMax(int x, int y) {
        int ans = 0;
        for (int i = x - 1; i < x + 2; i++) {
            for (int j = y - 1; j < y + 2; j++) {
                ans = Math.max(ans, g[i][j]);
            }
        }
        return ans;
    }
}