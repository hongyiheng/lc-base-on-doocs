class Solution:
    def crackSafe(self, n: int, k: int) -> str:
        def dfs(u):
            for i in range(k):
                v = u * 10 + i
                if v in vis:
                    continue
                vis.add(v)
                dfs(v % mod)
                ans.append(i)

        vis = set()
        mod = 10 ** (n - 1)
        ans = []
        dfs(0)
        ans += [0 for _ in range(n - 1)]
        return "".join(map(str, ans))