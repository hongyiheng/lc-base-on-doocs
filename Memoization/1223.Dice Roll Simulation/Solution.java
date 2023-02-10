class Solution {

    int[][][] f;
    int mod = (int)1e9 + 7;
    int n;
    int[] rollMax;

    public int dieSimulator(int n, int[] rollMax) {
        this.n = n;
        this.rollMax = rollMax;
        f = new int[n + 1][6][16];
        int ans = 0;
        for (int i = 0; i < 6; i++) {
            ans = (ans + dfs(1, i, 1)) % mod;
        }
        return ans;
    }

    public int dfs(int i, int last, int cnt) {
        if (i == n) {
            return 1;
        }
        if (f[i][last][cnt] != 0) {
            return f[i][last][cnt];
        }
        int ans = 0;
        for (int j = 0; j < 6; j++) {
            int mx = rollMax[j];
            if (last == j && cnt >= mx) {
                continue;
            }
            int s = dfs(i + 1, j, last == j ? cnt + 1 : 1);
            ans = (s + ans) % mod;
        }
        f[i][last][cnt] = ans;
        return ans;
    }
}