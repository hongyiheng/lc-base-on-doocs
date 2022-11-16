class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        dp = [0] * 366
        s = set(days)
        for i in range(1, 366):
            dp[i] = dp[i - 1]
            if i in s:
                dp[i] = dp[i] + costs[0]
                dp[i] = min(dp[i], dp[max(0, i - 7)] + costs[1])
                dp[i] = min(dp[i], dp[max(0, i - 30)] + costs[2])
        return dp[365]
