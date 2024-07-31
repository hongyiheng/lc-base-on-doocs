class Solution:
    def minRectanglesToCoverPoints(self, points: List[List[int]], w: int) -> int:
        points.sort(key=lambda x: x[0])
        ans, t = 0, -1
        for x, _ in points:
            if t < x:
                t = x + w
                ans += 1
        return ans
