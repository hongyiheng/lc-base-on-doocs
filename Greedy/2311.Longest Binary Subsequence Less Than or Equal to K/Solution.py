class Solution:
    def longestSubsequence(self, s: str, k: int) -> int:
        n = len(s)
        ans = 0
        for i in range(n - 1, -1, -1):
            v = l = 0
            for j in range(i, -1, -1):
                if s[j] == '1' and v + (1 << l) > k:
                    continue
                elif s[j] == '1':
                    v += 1 << l
                l += 1
            ans = max(ans, l)
        return ans