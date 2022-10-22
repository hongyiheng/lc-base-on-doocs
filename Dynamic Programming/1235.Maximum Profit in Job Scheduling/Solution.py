class Solution:
    def jobScheduling(self, startTime: List[int], endTime: List[int], profit: List[int]) -> int:
        n = len(startTime)
        dp = [0] * (n + 1)
        g = [(s, e, w) for s, e, w in zip(startTime, endTime, profit)]
        g.sort(key=lambda x:x[1])
        for i in range(1, n + 1):
            s, e, w = g[i - 1]
            dp[i] = max(dp[i - 1], w)
            l, r = 0, i - 1
            while l < r:
                mid = (l + r + 1) >> 1
                if g[mid][1] <= s:
                    l = mid
                else:
                    r = mid - 1
            if g[l][1] <= s:
                dp[i] = max(dp[i], dp[l + 1] + w)
        return dp[n]
