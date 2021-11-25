class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        int mod = (int) 1e9 + 7;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int j = 0; j < target + 1; j++) {
            for (int v = f; v >= 0; v--) {
                if (j >= v) {
                    dp[j] = (dp[j] + dp[j - v]) % mod;
                }
            }
        }
        return dp[target];
    }
}