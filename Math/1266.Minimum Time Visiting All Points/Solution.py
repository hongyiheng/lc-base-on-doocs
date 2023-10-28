class Solution:
    def minTimeToVisitAllPoints(self, points: List[List[int]]) -> int:
        ans = 0
        x, y = points[0]
        for nx, ny in points:
            ans += max(abs(nx - x), abs(ny - y))
            x, y = nx, ny
        return ans