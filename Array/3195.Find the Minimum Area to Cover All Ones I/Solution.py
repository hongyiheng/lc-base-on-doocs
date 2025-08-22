class Solution:
    def minimumArea(self, grid: List[List[int]]) -> int:
        t = l = 1010
        b = r = 0
        for i, row in enumerate(grid):
            for j, v in enumerate(row):
                if not v:
                    continue
                t = min(i, t)
                b = max(i, b)
                l = min(j, l)
                r = max(j, r)
        return (b - t + 1) * (r - l + 1)
