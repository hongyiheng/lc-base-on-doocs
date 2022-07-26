class Solution:
    def numberWays(self, hats: List[List[int]]) -> int:
        mod = int(1e9 + 7)
        n = len(hats)
        mp = defaultdict(list)
        for i, people in enumerate(hats):
            for p in people:
                mp[p].append(i)
        dp = [[0] * (1 << n) for _ in range(41)]
        dp[0][0] = 1
        for i in range(1, 41):
            for j in range(1 << n):
                dp[i][j] = dp[i - 1][j]
                for k in mp[i]:
                    if j & (1 << k):
                        dp[i][j] += dp[i - 1][j ^ (1 << k)]
                        dp[i][j] %= mod
        return dp[40][(1 << n) - 1]