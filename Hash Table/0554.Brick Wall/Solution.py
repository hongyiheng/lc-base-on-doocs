class Solution:
    def leastBricks(self, wall: List[List[int]]) -> int:
        m, n = len(wall), sum(wall[0])
        interval = defaultdict(int)
        for i, row in enumerate(wall):
            s = 0
            for v in row:
                s += v
                if s == n:
                    continue
                interval[s] += 1
        return m - max(interval.values()) if interval.values() else m


