class Solution:
    def findPermutationDifference(self, s: str, t: str) -> int:
        g = [0] * 26
        for i, c in enumerate(s):
            g[ord(c) - ord('a')] = i
        ans = 0
        for i, c in enumerate(t):
            ans += abs(g[ord(c) - ord('a')] - i)
        return ans