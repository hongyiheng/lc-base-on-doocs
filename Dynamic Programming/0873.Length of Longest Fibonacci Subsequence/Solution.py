class Solution:
    def lenLongestFibSubseq(self, arr: List[int]) -> int:
        n = len(arr)
        mp = dict()
        for i, v in enumerate(arr):
            mp[v] = i
        ans = 0
        dp = [[0] * n for _ in range(n)]
        for i in range(2, n):
            for j in range(1, i):
                t = arr[i] - arr[j]
                idx = mp.get(t, float('inf'))
                if idx < j:
                    dp[i][j] = max(dp[i][j], 3)
                    dp[i][j] = max(dp[i][j], dp[j][idx] + 1)
                    ans = max(ans, dp[i][j])
        return ans