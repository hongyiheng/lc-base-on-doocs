class Solution:
    def numDecodings(self, s: str) -> int:
        s = " " + s
        n = len(s)
        dp = [0] * n
        dp[0] = 1
        for i in range(1, n):
            cur = ord(s[i]) - ord('0')
            if cur >= 1 and cur <= 9:
                dp[i] = dp[i - 1]
            last = (ord(s[i - 1]) - ord('0')) * 10
            if last + cur >= 10 and last + cur <=26:
                dp[i] += dp[i - 2]
        return dp[n - 1]
