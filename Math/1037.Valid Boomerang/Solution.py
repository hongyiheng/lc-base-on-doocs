class Solution:
    def isBoomerang(self, points: List[List[int]]) -> bool:
        x1, y1 = points[0]
        x2, y2 = points[1]
        x3, y3 = points[2]
        return (y2 - y1) * (x3 - x1) != (y3 - y1) * (x2 - x1)
