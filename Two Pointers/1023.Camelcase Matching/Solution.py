class Solution:
    def camelMatch(self, queries: List[str], pattern: str) -> List[bool]:
        m, n = len(queries), len(pattern)
        ans = []
        for k, s in enumerate(queries):
            i = j = 0
            while i < n:
                if j >= len(s):
                    break
                if pattern[i] == s[j]:
                    i += 1
                elif s[j].isupper():
                    break
                j += 1
            while j < len(s) and s[j].islower():
                j += 1
            ans.append(i == n and j == len(s))
        return ans
