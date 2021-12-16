class Solution:
    def visiblePoints(self, points: List[List[int]], angle: int, location: List[int]) -> int:
        x, y = location[0], location[1]
        extra, pi, t = 0, math.pi, angle * math.pi / 180
        angles = []
        for p in points:
            a, b = p[0], p[1]
            if a == x and b == y:
                extra += 1
                continue
            angles.append(atan2(a - x, b - y) + pi)
        angles.sort()
        n, count = len(angles), 0
        for i in range(n):
            angles.append(angles[i] + 2 * pi)
        l, r = 0, 0
        for r in range(2 * n):
            while l < r and angles[r] - angles[l] > t:
                l += 1
            count = max(count, r - l + 1)
        return extra + count