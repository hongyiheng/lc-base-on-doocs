class Solution:
    def maxTaxiEarnings(self, n: int, rides: List[List[int]]) -> int:
        mp = dict()
        for r in rides:
            tmp = mp.get(r[1], list())
            tmp.append(r)
            mp[r[1]] = tmp
        dp = [0] * (n + 1)
        for i in range(1, n + 1):
            dp[i] = dp[i - 1]
            for r in mp.get(i, list()):
                dp[i] = max(dp[i], dp[r[0]] + r[1] - r[0] + r[2])
        return dp[n]