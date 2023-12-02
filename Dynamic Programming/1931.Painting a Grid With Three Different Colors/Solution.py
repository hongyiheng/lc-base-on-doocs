class Solution:
    def colorTheGrid(self, m: int, n: int) -> int:
        def dfs(path):
            if len(path) == m:
                masks.append(tuple(path))
                return
            for k in range(3):
                if path and path[-1] == k:
                    continue
                path.append(k)
                dfs(path)
                path.pop()

        masks = []
        dfs([])
        g = defaultdict(set)
        for i, m1 in enumerate(masks):
            for j, m2 in enumerate(masks):
                if any(m1[k] == m2[k] for k in range(m)):
                    continue
                g[i].add(j)
                g[j].add(i)

        f = [[0] * len(masks) for _ in range(n)]
        for i in range(len(masks)):
            f[0][i] = 1
        for i in range(n - 1):
            for j in range(len(masks)):
                for k in g[j]:
                    f[i + 1][k] += f[i][j]
        return sum(f[-1]) % int(1e9 + 7)

