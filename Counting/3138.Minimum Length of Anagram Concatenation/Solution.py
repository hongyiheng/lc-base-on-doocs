class Solution:
    def minAnagramLength(self, s: str) -> int:
        def check(x):
            t = pre[x]
            for i in range(2 * x, len(pre), x):
                for k in range(26):
                    if pre[i][k] - pre[i - x][k] != t[k]:
                        return False
            return True

        n = len(s)
        pre = [[0] * 26 for _ in range(n + 1)]
        for i, c in enumerate(s):
            pre[i + 1] = pre[i][::]
            pre[i + 1][ord(c) - ord('a')] += 1
        for i in range(1, n + 1):
            if n % i:
                continue
            if check(i):
                return i
        return -1