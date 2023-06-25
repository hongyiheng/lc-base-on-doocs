class Solution:
    def checkOverlap(self, radius: int, xCenter: int, yCenter: int, x1: int, y1: int, x2: int, y2: int) -> bool:
        x = 0 if x1 <= xCenter <= x2 else min(abs(x1 - xCenter), abs(x2 - xCenter))
        y = 0 if y1 <= yCenter <= y2 else min(abs(y1 - yCenter), abs(y2 - yCenter))
        return x * x + y * y <= radius * radius
