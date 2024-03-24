class Solution:
    def maximizeTheProfit(self, n: int, offers: List[List[int]]) -> int:
        f = [0] * n
        offers.sort(key=lambda x:x[1])
        j = 0
        for i in range(n):
            if i:
                f[i] = f[i - 1]
            while j < len(offers) and offers[j][1] <= i:
                s, e, w = offers[j]
                f[e] = max(f[e], (0 if s - 1 < 0 else f[s - 1]) + w)
                j += 1
        return f[n - 1]