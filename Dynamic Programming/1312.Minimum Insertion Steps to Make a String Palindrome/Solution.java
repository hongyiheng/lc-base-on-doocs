class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int[][] f = new int[n][n];
        for (int i = 1; i < n; i++) {
            f[i - 1][i] = cs[i - 1] == cs[i] ? 0 : 1;
        }
        for (int L = 3; L <= n; L++) {
            for (int l = 0; l < n; l++) {
                int r = l + L - 1;
                if (r >= n) {
                    break;
                }
                if (cs[l] == cs[r]) {
                    f[l][r] = f[l + 1][r - 1];
                } else {
                    f[l][r] = Math.min(f[l + 1][r], f[l][r - 1]) + 1;
                }
            }
        }
        return f[0][n - 1];
    }
}
