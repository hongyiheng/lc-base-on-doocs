class Solution:
    def checkStraightLine(self, coordinates: List[List[int]]) -> bool:
        for i in range(2, len(coordinates)):
            lx, ly = coordinates[i - 2]
            x, y = coordinates[i - 1]
            nx, ny = coordinates[i]
            if (x - lx) * (ny - ly) != (y - ly) * (nx - lx):
                return False
        return True