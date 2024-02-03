class Solution:
    def stoneGameVII(self, stones: List[int]) -> int:
        @cache
        def dfs(l, r):
            if l == r:
                return 0
            a = pre[r + 1] - pre[l + 1] - dfs(l + 1, r)
            b = pre[r] - pre[l] - dfs(l, r - 1)
            return max(a, b)

        n = len(stones)
        pre = [0] * (n + 1)
        for i in range(n):
            pre[i + 1] = pre[i] + stones[i]
        ans = dfs(0, n - 1)
        dfs.cache_clear()
        return ans