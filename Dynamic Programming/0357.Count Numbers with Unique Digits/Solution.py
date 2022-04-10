class Solution:
    def countNumbersWithUniqueDigits(self, n: int) -> int:
        dp = [0] * 10
        dp[0] = 1
        dp[1] = 9
        cur, num = 9, 9
        for i in range(2, n + 1):
            cur *= num
            dp[i] = cur
            num -= 1
        ans = 0
        for i in range(n + 1):
            ans += dp[i]
        return ans