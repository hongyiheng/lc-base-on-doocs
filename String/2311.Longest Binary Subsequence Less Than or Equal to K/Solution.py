class Solution:
    def longestSubsequence(self, s: str, k: int) -> int:
        n = len(s)
        ans = 0
        for i in range(n - 1, -1, -1):
            x = idx = 0
            for j in range(i, -1, -1):
                v = ord(s[j]) - ord('0')
                if not v:
                    idx += 1
                    continue
                if idx > 32 or x | 1 << idx > k:
                    continue
                x = x | 1 << idx
                idx += 1
            ans = max(ans, idx)
        return ans