class Solution:
    def isReachableAtTime(self, sx: int, sy: int, fx: int, fy: int, t: int) -> bool:
        if sx == fx and sy == fy and t == 1:
            return False
        dx, dy = abs(fx - sx), abs(fy - sy)
        return max(dx, dy) <= t