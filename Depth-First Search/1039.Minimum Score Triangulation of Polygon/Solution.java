class Solution {
    int[][] f;
    int n;
    int[] values;

    public int minScoreTriangulation(int[] values) {
        n = values.length;
        f = new int[n][n];
        this.values = values;
        for (int[] r : f) {
            Arrays.fill(r, -1);
        }
        return dfs(0, n - 1);
    }

    public int dfs(int i, int j) {
        if (j - i == 1) {
            return 0;
        }
        if (f[i][j] != -1) {
            return f[i][j];
        }
        int ans = 0x3f3f3f3f;
        for (int k = i + 1; k < j; k++) {
            int v = dfs(i, k) + dfs(k, j) + values[i] * values[j] * values[k];
            ans = Math.min(v, ans);
        }
        f[i][j] = ans;
        return ans;
    }
}