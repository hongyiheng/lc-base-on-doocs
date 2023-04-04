class Solution:
    def mergeStones(self, stones: List[int], k: int) -> int:
        n = len(stones)
        if (n - 1) % (k - 1):
            return -1
        s = [0] * (n + 1)
        for i in range(n):
            s[i + 1] = s[i] + stones[i]
        f = [[0x3f3f3f3f] * n for _ in range(n)]
        for i in range(n):
            f[i][i] = 0
        for i in range(n - 1, -1, -1):
            for j in range(i + 1, n):
                for o in range(i, j, k - 1):
                    f[i][j] = min(f[i][j], f[i][o] + f[o + 1][j])
                if (j - i) % (k - 1) == 0:
                    f[i][j] += s[j + 1] - s[i]
        return f[0][-1]