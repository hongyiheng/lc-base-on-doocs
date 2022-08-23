class Solution:
    def numDupDigitsAtMostN(self, n: int) -> int:
        s = str(n)
        m = len(s)

        @cache
        def dfs(cur, mask, limit, num, valid):
            if cur == m:
                return 1 if valid else 0
            ans = 0
            if not num:
                ans = dfs(cur + 1, 0, False, False, False)
            bottom, up = 0 if num else 1, int(s[cur]) if limit else 9
            for i in range(bottom, up + 1):
                ans += dfs(cur + 1, mask | (1 << i), limit and i == up, True, valid or mask & (1 << i))
            return ans

        return dfs(0, 0, True, False, False)