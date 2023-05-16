class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        int[][] f = new int[n + 1][d + 1];
        int inf = 0x3f3f3f3f;
        for (int[] r : f) {
            Arrays.fill(r, inf);
        }
        f[0][0] = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < d + 1; j++) {
                int x = 0;
                for (int k = i - 1; k > -1; k--) {
                    x = Math.max(x, jobDifficulty[k]);
                    f[i][j] = Math.min(f[i][j], f[k][j - 1] + x);
                }
            }
        }
        return f[n][d] >= inf ? -1 : f[n][d];
    }
}
