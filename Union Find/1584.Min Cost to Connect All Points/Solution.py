class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        n = len(points)
        p = list(range(n))

        def find(x):
            if p[x] != x:
                p[x] = find(p[x])
            return p[x]

        def union(a, b):
            p[find(a)] = find(b)

        def check(a, b):
            return find(a) == find(b)

        dist = []
        for i in range(n):
            xi, yi = points[i]
            for j in range(i + 1, n):
                xj, yj = points[j]
                d = abs(xi - xj) + abs(yi - yj)
                heapq.heappush(dist, [d, i, j])
        ans = cnt = 0
        while dist:
            d, i, j = heapq.heappop(dist)
            if check(i, j):
                continue
            ans += d
            cnt += 1
            union(i, j)
            if cnt == n - 1:
                return ans
        return ans