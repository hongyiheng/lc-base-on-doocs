class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        m = len(edges)
        p = [i for i in range(m + 1)]

        def find(x):
            if p[x] != x:
                p[x] = find(p[x])
            return p[x]

        def union(i1, i2):
            r1 = find(i1)
            r2 = find(i2)
            if (r1 != r2):
                p[r1] = r2

        for i in range(m):
            if find(edges[i][0]) != find(edges[i][1]):
                union(edges[i][0], edges[i][1])
            else:
                return edges[i]

        return edges[m - 1]