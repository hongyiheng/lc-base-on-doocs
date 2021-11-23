class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [1] + [0] * amount
        for v in coins:
            for j in range(v, amount + 1):
                dp[j] += dp[j - v]
        return dp[amount]