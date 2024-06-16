class Solution:
    def minRectanglesToCoverPoints(self, points: List[List[int]], w: int) -> int:
        q = [x for x, _ in points]
        q.sort()
        ans, cur = 0, -1
        for v in q:
            if cur < v:
                cur = v + w
                ans += 1
        return ans