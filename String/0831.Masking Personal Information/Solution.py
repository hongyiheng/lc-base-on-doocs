class Solution:
    def maskPII(self, s: str) -> str:
        if "@" in s:
            s = str.lower(s)
            idx = s.find('@')
            return s[0] + 5 * '*' + s[idx - 1:]
        q = []
        for c in s:
            if '0' <= c <= '9':
                q.append(c)
        ans = 3 * '*' + '-' + 3 * '*' + '-' + "".join(q)[-4:]
        if len(q) > 10:
            ans = '+' + (len(q) - 10) * '*' + '-' + ans
        return ans
