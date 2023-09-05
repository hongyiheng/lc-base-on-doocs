class Solution:
    def findRotateSteps(self, ring: str, key: str) -> int:
        n = len(ring)
        g = defaultdict(list)
        for i, v in enumerate(ring):
            g[v].append(i)
        f = [inf] * n
        for i in g[key[0]]:
            f[i] = min(i, n - i) + 1
        for i in range(1, len(key)):
            for v in g[key[i]]:
                mi = inf
                for u in g[key[i - 1]]:
                    mi = min(mi, f[u] + min(abs(u - v), n - abs(u - v)) + 1)
                f[v] = mi
        return min(f[v] for v in g[key[-1]])