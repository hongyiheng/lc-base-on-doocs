class Solution:
    def findPermutationDifference(self, s: str, t: str) -> int:
        idx = [-1] * 26
        for i, c in enumerate(s):
            idx[ord(c) - ord('a')] = i
        ans = 0
        for i, c in enumerate(t):
            ans += abs(idx[ord(c) - ord('a')] - i)
        return ans