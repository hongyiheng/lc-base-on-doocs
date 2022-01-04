class Solution:
    def modifyString(self, s: str) -> str:
        mp = ["a", "b", "c"]
        ans, n = "", len(s)
        for i, c in enumerate(s):
            if c == '?':
                for v in mp:
                    if (i > 0 and v == ans[-1]) or (i < n - 1 and v == s[i + 1]):
                        continue
                    c = v
                    break
            ans += c
        return ans