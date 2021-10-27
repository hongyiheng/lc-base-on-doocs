class Solution:
    def makeConnected(self, n: int, connections: List[List[int]]) -> int:
        p = [i for i in range(n)]
        need, extra = n - 1, 0

        def find(x):
            if p[x] != x:
                p[x] = find(p[x])
            return p[x]

        def union(i1, i2):
            nonlocal need, extra
            r1 = find(i1)
            r2 = find(i2)
            if r1 != r2:
                p[r1] = r2
                need -= 1
            else:
                extra += 1

        for item in connections:
            union(item[0], item[1])
        return -1 if need > extra else need