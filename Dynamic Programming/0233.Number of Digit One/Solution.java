class Solution {
    char[] cs;
    int[][] dp;
    int m;

    public int countDigitOne(int n) {
        cs = String.valueOf(n).toCharArray();
        m = cs.length;
        dp = new int[m][m];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }
        return dfs(0, 0, true);
    }

    public int dfs(int cur, int cnt, boolean limit) {
        if (cur == m) {
            return cnt;
        }
        if (!limit && dp[cur][cnt] >= 0) {
            return dp[cur][cnt];
        }
        int ans = 0;
        int up = limit ? cs[cur] - '0' : 9;
        for (int i = 0; i < up + 1; i++) {
            int nextCnt = cnt;
            nextCnt += i == 1 ? 1 : 0;
            ans += dfs(cur + 1, nextCnt, limit && i == up);
        }
        if (!limit) {
            dp[cur][cnt] = ans;
        }
        return ans;
    }
}