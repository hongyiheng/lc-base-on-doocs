class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }
        int[][] ans = new int[r][c];
        int idx = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int x = idx / n, y = idx % n;
                ans[i][j] = mat[x][y];
                idx++;
            }
        }
        return ans;
    }
}