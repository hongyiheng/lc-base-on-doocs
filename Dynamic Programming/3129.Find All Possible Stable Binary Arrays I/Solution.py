class Solution:
    def numberOfStableArrays(self, zero: int, one: int, limit: int) -> int:
        @cache
        def dfs(i, j, k):
            if i == 0:
                return 1 if k == 1 and j <= limit else 0
            if j == 0:
                return 1 if k == 0 and i <= limit else 0
            if k == 0:
                return (dfs(i - 1, j, 0) + dfs(i - 1, j, 1) - (dfs(i - limit - 1, j, 1) if i > limit else 0)) % MOD
            else:
                return (dfs(i, j - 1, 0) + dfs(i, j - 1, 1) - (dfs(i, j - limit - 1, 0) if j > limit else 0)) % MOD
            return ans % MOD

        MOD = int(1e9) + 7
        ans = (dfs(zero, one, 0) + dfs(zero, one, 1)) % MOD
        dfs.cache_clear()
        return ans
