class Solution:
    def minimumTime(self, s: str) -> int:
        n = len(s)
        suf = [0] * (n + 1)
        for i in range(n - 1, -1, -1):
            suf[i] = suf[i + 1]
            if s[i] == '1':
                suf[i] = min(suf[i] + 2, n - i)
        pre, ans = 0, suf[0]
        for i in range(n):
            if s[i] == '1':
                pre = min(pre + 2, i + 1)
            ans = min(ans, pre + suf[i + 1])
        return ans