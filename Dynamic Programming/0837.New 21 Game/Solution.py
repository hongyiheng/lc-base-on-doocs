class Solution:
    def new21Game(self, n: int, k: int, maxPts: int) -> float:
        if k == 0 or k + maxPts <= n:
            return 1
        f = [1] * (n + 1)
        cur = 0
        for i in range(1, n + 1):
            if i <= k:
                cur += f[i - 1]
            if i > maxPts:
                cur -= f[i - 1 - maxPts]
            f[i] = cur / maxPts
        return sum(f[k:])
