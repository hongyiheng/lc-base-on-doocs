class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                grid[i][j] ^= 1;
            }
        }
        for (int j = 0; j < n; j++) {
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) {
                    cnt++;
                }
            }
            if (cnt * 2 >= m) {
               continue;
            }
            for (int i = 0; i < m; i++) {
                grid[i][j] ^= 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ans += 1 << (n - j - 1);
                }
            }
        }
        return ans;
    }
}