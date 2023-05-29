class Solution:
    def twoEggDrop(self, n: int) -> int:
        f = [inf] * (n +1)
        f[0] = 0
        for i in range(1, n + 1):
            for j in range(1, i + 1):
                    f[i] = min(max(f[i - j] + 1, j), f[i])
        return f[n]