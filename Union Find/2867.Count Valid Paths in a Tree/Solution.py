class Solution:
    def countPaths(self, n: int, edges: List[List[int]]) -> int:
        def getPrime(n):
            primes = [False] * n
            for i in range(2, n):
                if not primes[i]:
                    for j in range(i * i, n, i):
                        primes[j] = True
            primes[1] = True
            return primes

        def find(x):
            if p[x] != x:
                p[x] = find(p[x])
            return p[x]

        def union(a, b):
            r1, r2 = find(a), find(b)
            if r1 != r2:
                size[r2] += size[r1]
                p[r1] = r2

        primes = getPrime(n + 1)
        p = [i for i in range(n + 1)]
        size = [1] * (n + 1)

        g = defaultdict(list)
        for u, v in edges:
            if primes[u] and primes[v]:
                union(u, v)
            g[u].append(v)
            g[v].append(u)
        ans = 0
        for u in range(1, n + 1):
            s = 0
            if primes[u]:
                continue
            for v in g[u]:
                if not primes[v]:
                    continue
                cnt = size[find(v)]
                ans += cnt
                ans += s * cnt
                s += cnt
        return ans