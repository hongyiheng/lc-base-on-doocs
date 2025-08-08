class Solution {

    double[][] f;

    public double dfs(int a, int b) {
        if (a <= 0 && b <= 0) {
            return 0.5;
        }
        if (a <= 0) {
            return 1.0;
        }
        if (b <= 0) {
            return 0;
        }
        if (f[a][b] != -1) {
            return f[a][b];
        }
        f[a][b] = (dfs(a - 100, b) + dfs(a - 75, b - 25) + dfs(a - 50, b - 50) + dfs(a - 25, b - 75)) / 4.0;
        return f[a][b];
    }

    public double soupServings(int n) {
        if (n >= 5000) {
            return 1.0;
        }
        f = new double[n + 1][n + 1];
        for (double[] row : f) {
            Arrays.fill(row, -1);
        }
        return dfs(n, n);
    }
}