class Solution:
    def largestTriangleArea(self, points: List[List[int]]) -> float:
        def edge(u, v):
            a, b = u[0] - v[0], u[1] - v[1]
            return sqrt(a * a + b * b)

        def get_area(a, b, c):
            p = (a + b + c) * 0.5
            num = p * (p - a) * (p - b) * (p - c)
            if num <= 0:
                return 0
            return sqrt(num)

        n = len(points)
        ans = 0
        for i in range(n):
            for j in range(i, n):
                for k in range(j, n):
                    p1, p2, p3 = points[i], points[j], points[k]
                    a, b, c = edge(p1, p2), edge(p1, p3), edge(p2, p3)
                    ans = max(ans, get_area(a, b, c))
        return ans