class Solution:
    def stoneGame(self, piles: List[int]) -> bool:
        n = len(piles)
        dp = [[0] * (n + 2) for _ in range(n + 2)]
        for m in range(1, n + 1):
            for l in range(1, n - m + 2):
                r = l + m - 1
                a = piles[l - 1] - dp[l - 1][r]
                b = piles[r - 1] - dp[l][r - 1]
                dp[l][r] = max(a, b)
        return dp[1][n] > 0