class Solution:
    def longestSemiRepetitiveSubstring(self, s: str) -> int:
        n = len(s)
        ans = min(1, n)
        for i in range(n):
            last = s[i]
            k = -1
            for j in range(i + 1, n):
                if s[j] == last:
                    k += 1
                    if k:
                        ans = max(ans, j - i)
                        break
                last = s[j]
            if k <= 0:
                ans = max(ans, n - i)
                break
        return ans