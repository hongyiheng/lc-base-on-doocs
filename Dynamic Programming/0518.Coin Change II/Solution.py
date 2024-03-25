class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        f = [0] * (amount + 1)
        f[0] = 1
        for v in coins:
            for j in range(v, amount + 1):
                f[j] += f[j - v]
        return f[amount]