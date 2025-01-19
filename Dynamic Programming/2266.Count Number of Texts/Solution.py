class Solution:
    def countTexts(self, pressedKeys: str) -> int:
        n = len(pressedKeys)
        mod = int(1e9 + 7)
        f = [[0] * 2 for _ in range(max(4, n) + 1)]
        f[0][0] = f[0][1] = 1
        f[1][0] = f[1][1] = 1
        f[2][0] = f[2][1] = 2
        f[3][0] = f[3][1] = 4
        for i in range(4, n + 1):
            f[i][0] = (f[i - 1][0] + f[i - 2][0] + f[i - 3][0]) % mod
            f[i][1] = (f[i - 1][1] + f[i - 2][1] + f[i - 3][1] + f[i - 4][1]) % mod
        ans = 1
        cnt = 0
        for i in range(n):
            c = pressedKeys[i]
            cnt += 1
            if i == n - 1 or c != pressedKeys[i + 1]:
                ans = ans * (f[cnt][1] if c == '7' or c == '9' else f[cnt][0]) % mod
                cnt = 0
        return ans % mod
