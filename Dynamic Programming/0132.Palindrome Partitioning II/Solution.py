class Solution:
    def minCut(self, s: str) -> int:
        @cache
        def check(l, r):
            if l >= r:
                return True
            return s[l] == s[r] and check(l + 1, r - 1)

        @cache
        def dfs(r):
            if check(0, r):
                return 0
            res = inf
            for l in range(1, r + 1):
                if check(l, r):
                    res = min(res, dfs(l - 1) + 1)
            return res

        return dfs(len(s) - 1)