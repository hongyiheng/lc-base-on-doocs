class Solution:
    def validPath(self, n: int, edges: List[List[int]], start: int, end: int) -> bool:
        p = [i for i in range(n)]

        def find(x):
            if p[x] != x:
                p[x] = find(p[x])
            return p[x]

        def union(i1, i2):
            r1, r2 = find(i1), find(i2)
            if r1 != r2:
                p[r1] = r2

        for edge in edges:
            union(edge[0], edge[1])
        return find(start) == find(end)