class Solution:
    def numOfWays(self, n: int) -> int:
        M = int(1e9 + 7)
        # 三色 f1, 双色 f2
        f1 = f2 = 6
        for i in range(1, n):
            # 每个三色的下一行, 有 2 个三色, 2 个双色
            # 每个双色的下一行, 有 2 个三色, 3 个双色
            nf1 = f1 * 2 + f2 * 2
            nf2 = f1 * 2 + f2 * 3
            f1, f2 = nf1 % M, nf2 % M
        return (f1 + f2) % M



class Solution:
    def numOfWays(self, n: int) -> int:
        def dfs(path):
            if len(path) == 3:
                masks.append("".join(path))
                return
            for i in range(3):
                if path and str(i) == path[-1]:
                    continue
                path.append(str(i))
                dfs(path)
                path.pop()

        masks = []
        dfs([])

        g = defaultdict(set)
        for i, m1 in enumerate(masks):
            for j, m2 in enumerate(masks):
                if not any(m1[k] == m2[k] for k in range(3)):
                    g[i].add(j)
                    g[j].add(i)

        M = int(1e9 + 7)
        f = [[0] * len(masks) for _ in range(n)]
        for i in range(len(masks)):
            f[0][i] = 1
        for i in range(1, n):
            for j in range(len(masks)):
                for k in g[j]:
                    f[i][j] += f[i - 1][k]
                    f[i][j] %= M
        return sum(f[-1]) % M

