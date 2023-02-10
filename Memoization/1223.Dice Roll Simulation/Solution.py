class Solution:
    def dieSimulator(self, n: int, rollMax: List[int]) -> int:
        mod = int(1e9 + 7)

        @cache
        def dfs(i, last, cnt):
            if i == n:
                return 1
            res = 0
            for j, rm in enumerate(rollMax):
                if j == last and cnt >= rm:
                    continue
                res += dfs(i + 1, j, cnt + 1 if last == j else 1)
            return res % mod

        ans = 0
        for i, rm in enumerate(rollMax):
            ans += dfs(1, i, 1)
        return ans % mod