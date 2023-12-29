class Solution:
    def numberOfSets(self, n: int, maxDistance: int, roads: List[List[int]]) -> int:
        def dfs(i, mask):
            if i == n:
                masks.add(mask)
                return
            dfs(i + 1, mask)
            dfs(i + 1, mask | 1 << i)

        def check(mask):
            f = [[inf] * n for _ in range(n)]
            for u, v, w in roads:
                if not mask >> u & 1 or not mask >> v & 1:
                    continue
                f[v][u] = f[u][v] = min(f[u][v], w)
            for k in range(n):
                for i in range(n):
                    for j in range(i + 1, n):
                        f[i][j] = f[j][i] = min(f[i][j], f[i][k] + f[k][j])
            for u in range(n):
                for v in range(u + 1, n):
                    if not mask >> u & 1 or not mask >> v & 1:
                        continue
                    if f[u][v] > maxDistance:
                        return False
            return True

        masks = set()
        dfs(0, 0)
        ans = 0
        for mask in masks:
            if check(mask):
                ans += 1
        return ans

