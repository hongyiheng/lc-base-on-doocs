class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int v = 0, cnt = 0;
                for (int x = Math.max(0, i - 1); x < Math.min(m, i + 2); x++) {
                    for (int y = Math.max(0, j - 1); y < Math.min(n, j + 2); y++) {
                        v += img[x][y];
                        cnt++;
                    }
                }
                ans[i][j] = v / cnt;
            }
        }
        return ans;
    }
}