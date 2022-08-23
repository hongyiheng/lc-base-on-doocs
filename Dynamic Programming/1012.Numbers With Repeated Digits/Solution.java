class Solution {
    char[] cs;
    int[][] dp;
    int m;

    public int numDupDigitsAtMostN(int n) {
        String s = String.valueOf(n);
        m = s.length();
        cs = s.toCharArray();
        dp = new int[m][4096];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }
        return dfs(0, 0, true, false, false);
    }

    public int dfs(int cur, int mask, boolean limit, boolean num, boolean valid) {
        if (cur == m) {
            return valid ? 1 : 0;
        }
        if (!limit && num && valid && dp[cur][mask] != -1) {
            return dp[cur][mask];
        }
        int ans = 0;
        if (!num) {
            ans = dfs(cur + 1, 0, false, false, false);
        }
        int bottom = num ? 0 : 1, up = limit ? cs[cur] - '0' : 9;
        for (int i = bottom; i < up + 1; i++) {
            ans += dfs(cur + 1, mask | (1 << i), limit && i == up, true, valid || (mask & (1 << i)) != 0);
        }
        if (!limit && num && valid) {
            dp[cur][mask] = ans;
        }
        return ans;
    }
}