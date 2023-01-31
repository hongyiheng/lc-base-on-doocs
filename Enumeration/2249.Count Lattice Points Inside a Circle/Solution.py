class Solution:
    def countLatticePoints(self, circles: List[List[int]]) -> int:
        s = set()
        for x, y, r in circles:
            for i in range(x - r, x + r + 1):
                for j in range(y - r, y + r + 1):
                    if math.sqrt(abs(i - x) ** 2 + abs(j - y) ** 2) <= r:
                        s.add((i, j))
        return len(s)
