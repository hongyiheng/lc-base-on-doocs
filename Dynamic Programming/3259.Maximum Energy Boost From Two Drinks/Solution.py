class Solution:
    def maxEnergyBoost(self, energyDrinkA: List[int], energyDrinkB: List[int]) -> int:
        n = len(energyDrinkA)
        f = [[0] * 2 for _ in range(n + 1)]
        for i in range(1, n + 1):
            a, b = energyDrinkA[i - 1], energyDrinkB[i - 1]
            f[i][0] = f[i - 1][0] + a
            f[i][1] = f[i - 1][1] + b
            if i >= 2:
                f[i][0] = max(f[i][0], f[i - 2][1] + a)
                f[i][1] = max(f[i][1], f[i - 2][0] + b)
        return max(f[-1])