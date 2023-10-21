class Solution:
    def countPairs(self, n: int, edges: List[List[int]]) -> int:
        def find(x):
            if p[x] != x:
                p[x] = find(p[x])
            return p[x]

        def union(a, b):
            r1, r2 = find(a), find(b)
            if r1 != r2:
                cnt[r2] += cnt[r1]
                cnt[r1] = 0
                p[find(a)] = find(b)

        p = [i for i in range(n)]
        cnt = [1] * n
        for u, v in edges:
            union(u, v)
        ans = pre = 0
        for i in range(n):
            if p[i] != i:
                continue
            ans += pre * cnt[i]
            pre += cnt[i]
        return ans

