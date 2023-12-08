class Solution:
    def maxTaxiEarnings(self, n: int, rides: List[List[int]]) -> int:
        rides.sort(key=lambda x:x[1])
        f = [0] * (n + 1)
        j = 0
        for i in range(n + 1):
            f[i] = f[i - 1]
            while j < len(rides) and rides[j][1] == i:
                s, e, t = rides[j]
                f[i] = max(f[i], f[s] + e - s + t)
                j += 1
        return f[n]