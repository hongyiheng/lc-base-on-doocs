class Solution {
    public int minimumOperationsToWriteY(int[][] grid) {
        int n = grid.length, mid = grid.length / 2;
        int[][] cnt = new int[2][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int v = grid[i][j];
                if (i <= mid) {
                    if (j == i || j == n - i - 1) {
                        cnt[0][v]++;
                    } else {
                        cnt[1][v]++;
                    }
                } else {
                    if (j == mid) {
                        cnt[0][v]++;
                    } else {
                        cnt[1][v]++;
                    }
                }
            }
        }
        int ans = n * n;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    continue;
                }
                int v = cnt[0][(i + 1) % 3] + cnt[0][(i + 2) % 3] + cnt[1][(j + 1) % 3] + cnt[1][(j + 2) % 3];
                ans = Math.min(ans, v);
            }
        }
        return ans;
    }
}