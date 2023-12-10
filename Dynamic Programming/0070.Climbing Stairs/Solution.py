class Solution:
    def climbStairs(self, n: int) -> int:
        f = [0] * (n + 1)
        f[0] = 1
        for i in range(1, n + 1):
            f[i] += f[i - 1]
            if i >= 2:
                f[i] += f[i - 2]
        return f[n]
