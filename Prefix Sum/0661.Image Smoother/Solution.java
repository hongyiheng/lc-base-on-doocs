class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length;
        int[][] pre = new int[m + 2][n + 2];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <=n; j++) {
                pre[i][j] = pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1] + img[i - 1][j - 1];
            }
        }
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int top = Math.max(0, i - 1);
                int bottom = Math.min(m - 1, i + 1);
                int left = Math.max(0, j - 1);
                int right = Math.min(n - 1, j + 1);
                int cnt = (bottom - top + 1) * (right - left + 1);
                int val = pre[bottom + 1][right + 1] - pre[top][right + 1] - pre[bottom + 1][left] + pre[top][left];
                ans[i][j] = val / cnt;
            }
        }
        return ans;
    }
}