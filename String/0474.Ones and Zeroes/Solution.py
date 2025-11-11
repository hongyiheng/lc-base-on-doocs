class Solution:
    def findMaxForm(self, strs: List[str], m: int, n: int) -> int:
        @cache
        def dfs(i, m, n):
            if i >= len(strs):
                return 0
            cnt = Counter(strs[i])
            ans = 0
            if cnt['0'] <= m and cnt['1'] <= n:
                ans = dfs(i + 1, m - cnt['0'], n - cnt['1']) + 1
            ans = max(ans, dfs(i + 1, m, n))
            return ans

        return dfs(0, m, n)