class Solution:

    def getMoneyAmount(self, n: int) -> int:
        @cache
        def dfs(l, r):
            if l + 1 == r:
                return l
            if l >= r:
                return 0
            ans = inf
            for k in range(l, r + 1):
                ans = min(ans, max(dfs(l, k - 1), dfs(k + 1, r)) + k)
            return ans

        return dfs(1, n)