class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int v : coins) {
            for (int j = v; j < amount + 1; j++) {
                dp[j] += dp[j - v];
            }
        }
        return dp[amount];
    }
}