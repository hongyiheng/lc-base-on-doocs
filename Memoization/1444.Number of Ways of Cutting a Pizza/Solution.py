class Solution:
    def ways(self, pizza: List[str], k: int) -> int:
        @cache
        def dfs(x, y, k):
            cur = s[m][n] - s[x][n] - s[m][y] + s[x][y]
            if k == 0:
                return 1 if cur > 0 else 0
            ans = 0
            for i in range(x + 1, m + 1):
                v = s[m][n] - s[i][n] - s[m][y] + s[i][y]
                if cur > v:
                    ans += dfs(i, y, k - 1)
            for j in range(y + 1, n + 1):
                v = s[m][n] - s[x][n] - s[m][j] + s[x][j]
                if cur > v:
                    ans += dfs(x, j, k - 1)
            return ans % mod

        mod = int(1e9 + 7)
        m, n = len(pizza), len(pizza[0])
        s = [[0] * (n + 1) for _ in range(m + 1)]
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + (1 if pizza[i - 1][j - 1] == 'A' else 0)
        return dfs(0, 0, k - 1)