class Solution:
    def minimumCoins(self, prices: List[int]) -> int:
        n = len(prices)
        f = [0x3f3f3f3f] * (n + 1)
        f[0] = 0
        for i in range(1, n + 1):
            for j in range(i // 2, i + 1):
                if 2 * j < i:
                    continue
                f[i] = min(f[i], f[j - 1] + prices[j - 1])
        return f[n]
