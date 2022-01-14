class Solution:
    def nthUglyNumber(self, n: int) -> int:
        dp = [0] * 1691
        dp[1] = 1
        i2, i3, i5 = 1, 1, 1
        for i in range(2, n + 1):
            num2, num3, num5 = dp[i2] * 2, dp[i3] * 3, dp[i5] * 5
            dp[i] = min(min(num2, num3), num5)
            if dp[i] == num2:
                i2 += 1
            if dp[i] == num3:
                i3 += 1
            if dp[i] == num5:
                i5 += 1
        return dp[n]