class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int l = original.length;
        if (m * n != l) {
            return new int[][]{};
        }
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = original[i * n + j];
            }
        }
        return ans;
    }
}