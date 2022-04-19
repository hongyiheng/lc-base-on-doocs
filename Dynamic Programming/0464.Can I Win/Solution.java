class Solution {
    int[] dp;
    int maxChoosableInteger;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) {
            return true;
        }
        if ((1 + maxChoosableInteger) / 2 * maxChoosableInteger < desiredTotal) {
            return false;
        }
        this.maxChoosableInteger = maxChoosableInteger;
        dp = new int[1 << maxChoosableInteger];
        Arrays.fill(dp, -1);
        return dfs(desiredTotal, 0) == 1;
    }

    public int dfs(int target, int state) {
        if (dp[state] != -1) {
            return dp[state];
        }
        for (int i = 1; i <= maxChoosableInteger; i++) {
            int idx = 1 << (i - 1);
            if ((idx & state) == 0) {
                if (i >= target || dfs(target - i, state | idx) == 0) {
                    dp[state] = 1;
                    return dp[state];
                }
            }
        }
        dp[state] = 0;
        return dp[state];
    }
}