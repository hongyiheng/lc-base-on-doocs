class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] f = new int[n][n];
        for (int l = 2; l < n; l++) {
            for (int i = 0; i < n; i++) {
                int j = i + l;
                if (j >= n) {
                    continue;
                }
                int v = 0x3f3f3f3f;
                for (int k = i + 1; k < j; k++) {
                    v = Math.min(v, f[i][k] + f[k][j] + values[i] * values[j] * values[k]);
                }
                f[i][j] = v;
            }
        }
        return f[0][n - 1];
    }
}