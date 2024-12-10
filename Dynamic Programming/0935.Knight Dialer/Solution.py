class Solution:
    def knightDialer(self, n: int) -> int:
        f = [[0] * 10 for _ in range(n + 1)]
        f[1] = [1] * 10
        for i in range(2, n + 1):
            f[i][0] = f[i - 1][4] + f[i - 1][6]
            f[i][1] = f[i - 1][8] + f[i - 1][6]
            f[i][2] = f[i - 1][7] + f[i - 1][9]
            f[i][3] = f[i - 1][4] + f[i - 1][8]
            f[i][4] = f[i - 1][0] + f[i - 1][3] + f[i - 1][9]
            f[i][6] = f[i - 1][0] + f[i - 1][1] + f[i - 1][7]
            f[i][7] = f[i - 1][2] + f[i - 1][6]
            f[i][8] = f[i - 1][1] + f[i - 1][3]
            f[i][9] = f[i - 1][4] + f[i - 1][2]
        return sum(f[n]) % int(1e9 + 7)
