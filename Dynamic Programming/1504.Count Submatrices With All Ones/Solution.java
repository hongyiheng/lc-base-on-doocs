class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] hs = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    continue;
                }
                hs[i][j] = i == 0 ? 1 : hs[i - 1][j] + 1;
                int h = hs[i][j];
                ans += h;
                for (int y = j - 1; y >= 0; y--) {
                    h = Math.min(h, hs[i][y]);
                    ans += h;
                }
            }
        }
        return ans;
    }
}
