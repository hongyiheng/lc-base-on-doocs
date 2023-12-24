class Solution:
    def minimumPerimeter(self, neededApples: int) -> int:
        i, c, s = 1, 1, 12
        while s < neededApples:
            c = c + (2 * i) - 1
            c += (i + 1) * 2 * 2
            s += (c + i + 1) * 4
            i += 1
        return (2 * i - 1) * 4 + 4

