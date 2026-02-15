class Solution:
    def addBinary(self, a: str, b: str) -> str:
        add = False
        m, n = len(a), len(b)
        ans = []
        for i in range(max(m, n)):
            av = 1 if i < m and a[m - i - 1] == '1' else 0
            bv = 1 if i < n and b[n - i - 1] == '1' else 0
            v = av + bv + (1 if add else 0)
            ans.append(str(v % 2))
            add = v >= 2
        if add:
            ans.append('1')
        return "".join(ans[::-1])