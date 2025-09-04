class Solution:
    def findClosest(self, x: int, y: int, z: int) -> int:
        d = abs(z - x) - abs(z - y)
        if not d:
            return 0
        return 2 if d > 0 else 1