class Solution:
    def uniqueLetterString(self, s: str) -> int:
        n = len(s)
        mp = dict()
        l, r = [0] * n, [0] * n
        for i, c in enumerate(s):
            l[i] = mp.get(c, -1)
            mp[c] = i
        mp.clear()
        for i in range(n - 1, -1, -1):
            c = s[i]
            r[i] = mp.get(c, n)
            mp[c] = i
        ans = 0
        for i in range(n):
            ans += (i - l[i]) * (r[i] - i)
        return ans