class Solution {
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if ((n - 1) % (k - 1) != 0) {
            return -1;
        }
        int[] s = new int[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + stones[i];
        }
        int[][] f = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], 0x3f3f3f3f);
            f[i][i] = 0;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                for (int o = i; o < j; o += k - 1) {
                    f[i][j] = Math.min(f[i][j], f[i][o] + f[o + 1][j]);
                }
                if ((j - i) % (k - 1) == 0) {
                    f[i][j] += s[j + 1] - s[i];
                }
            }
        }
        return f[0][n - 1];
    }
}