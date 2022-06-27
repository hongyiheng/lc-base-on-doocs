class Solution:
    def findLUSlength(self, strs: List[str]) -> int:
        def check(a, b):
            m, n = len(a), len(b)
            if m > n:
                return False
            f = [[0] * (n + 1) for _ in range(m + 1)]
            for i in range(1, m + 1):
                for j in range(1, n + 1):
                    if a[i - 1] == b[j - 1]:
                        f[i][j] = f[i - 1][j - 1] + 1
                    f[i][j] = max(f[i][j], f[i][j - 1])
                    f[i][j] = max(f[i][j], f[i - 1][j])
                    if f[i][j] == m:
                        return True
            return False

        n = len(strs)
        ans = -1
        for i in range(n):
            if len(strs[i]) < ans:
                continue
            flag = True
            for j in range(n):
                if i == j:
                    continue
                if check(strs[i], strs[j]):
                    flag = False
                    break
            if flag:
                ans = len(strs[i])
        return ans

