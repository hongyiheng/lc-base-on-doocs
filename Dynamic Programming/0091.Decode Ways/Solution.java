class Solution {
    public int numDecodings(String s) {
        s = " " + s;
        int len = s.length();
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            int cur = s.charAt(i) - '0';
            if (cur >= 1 && cur <= 9) {
                dp[i] = dp[i - 1];
            }
            int last = s.charAt(i - 1) - '0';
            int union = last * 10 + cur;
            if (union >= 10 && union <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[len - 1];
    }
}