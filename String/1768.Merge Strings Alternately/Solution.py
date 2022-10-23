class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        n, m, idx = len(word1), len(word2), 0
        ans = ""
        while idx < n or idx < m:
            if idx < n:
                ans += word1[idx]
            if idx < m:
                ans += word2[idx]
            idx += 1
        return ans
