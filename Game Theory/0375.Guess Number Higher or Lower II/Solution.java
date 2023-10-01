class Solution {
    int[][] f;

    public int dfs(int l, int r) {
        if (l + 1 == r) {
            return l;
        }
        if (l >= r) {
            return 0;
        }
        if (f[l][r] != 0) {
            return f[l][r];
        }
        int ans = 0x3f3f3f3f;
        for (int k = l; k <= r; k++) {
            ans = Math.min(ans, Math.max(dfs(l, k - 1), dfs(k + 1, r)) + k);
        }
        f[l][r] = ans;
        return ans;
    }

    public int getMoneyAmount(int n) {
        f = new int[n + 1][n + 1];
        return dfs(1, n);
    }
}