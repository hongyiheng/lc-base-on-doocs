class Solution:
    def collectTheCoins(self, coins: List[int], edges: List[List[int]]) -> int:
        n = len(coins)
        to = [0] * n
        g = defaultdict(list)
        for u, v in edges:
            g[u].append(v)
            g[v].append(u)
            to[u] += 1
            to[v] += 1
        cnt = len(edges)
        q = []
        for i, v in enumerate(to):
            if v == 1 and not coins[i]:
                q.append(i)
        while q:
            v = q.pop()
            cnt -= 1
            for u in g[v]:
                to[u] -= 1
                if to[u] == 1 and not coins[u]:
                    q.append(u)
        for i, v in enumerate(to):
            if v == 1 and coins[i]:
                q.append(i)
        for v in q:
            cnt -= 1
            for u in g[v]:
                to[u] -= 1
                if to[u] == 1:
                    cnt -= 1
        return max(cnt * 2, 0)