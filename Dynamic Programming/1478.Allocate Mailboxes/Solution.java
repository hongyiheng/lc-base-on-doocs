class Solution {
    public int minDistance(int[] houses, int k) {
        int n = houses.length;
        Arrays.sort(houses);
        int[][] cost = new int[n][n];
        for (int i = n - 2; i > -1; i--) {
            for (int j = i + 1; j < n; j++) {
                if (j - i <= 2) {
                    cost[i][j] = houses[j] - houses[i];
                } else {
                    cost[i][j] = cost[i + 1][j - 1] + houses[j] - houses[i];
                }
            }
        }
        int[][] f = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            f[i][1] = cost[0][i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 2; j <= Math.min(i, k); j++) {
                f[i][j] = f[i][j - 1];
                for (int p = 1; p <= i; p++) {
                    f[i][j] = Math.min(f[i][j], f[i - p][j - 1] + cost[i - p + 1][i]);
                }
            }
        }
        return f[n - 1][k];
    }
}
