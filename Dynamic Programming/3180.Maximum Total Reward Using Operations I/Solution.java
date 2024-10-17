class Solution {
    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        int n = rewardValues.length, m = 4000;
        boolean[][] f = new boolean[n + 1][m];
        f[0][0] = true;
        for (int i = 1; i < n + 1; i++) {
            int v = rewardValues[i - 1];
            for (int j = 0; j < m; j++) {
                f[i][j] = f[i - 1][j];
                if (v <= j && j < 2 * v && f[i - 1][j - v]) {
                    f[i][j] = true;
                }
            }
        }
        for (int i = m - 1; i > -1; i--) {
            if (f[n][i]) {
                return i;
            }
        }
        return 0;
    }
}