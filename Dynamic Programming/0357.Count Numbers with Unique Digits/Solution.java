class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int[] dp = new int[10];
        dp[0] = 1;
        dp[1] = 9;
        int cur = 9, num = 9;
        for (int i = 2; i <= n; i++) {
            cur *= num--;
            dp[i] = cur;
        }
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            ans += dp[i];
        }
        return ans;
    }
}