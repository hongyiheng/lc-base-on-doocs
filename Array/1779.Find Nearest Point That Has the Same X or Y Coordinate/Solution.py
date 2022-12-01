class Solution:
    def nearestValidPoint(self, x: int, y: int, points: List[List[int]]) -> int:
        ans, d = -1, float('inf')
        for i, v in enumerate(points):
            if v[0] != x and v[1] != y:
                continue
            dis = abs(x - v[0]) + abs(y - v[1])
            if dis < d:
                d = dis
                ans = i
        return ans
