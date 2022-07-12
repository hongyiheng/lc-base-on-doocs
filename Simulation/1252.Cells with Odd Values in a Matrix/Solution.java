class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] g = new int[m][n];
        for (int[] r : indices) {
            int x = r[0], y = r[1];
            for (int j = 0; j < n; j++) {
                g[x][j]++;
            }
            for (int i = 0; i < m; i++) {
                g[i][y]++;
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] % 2 != 0) {
                    ans++;
                }
            }
        }
        return ans;
    }
}