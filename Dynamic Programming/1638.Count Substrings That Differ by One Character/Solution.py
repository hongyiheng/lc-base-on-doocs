class Solution:
    def countSubstrings(self, s: str, t: str) -> int:
        n, m = len(s), len(t)
        ans = 0
        for i in range(n):
            for j in range(m):
                w = diff = 0
                while i + w < n and j + w < m and diff <= 1:
                    if s[i + w] != t[j + w]:
                        diff += 1
                    if diff == 1:
                        ans += 1
                    w += 1
        return ans