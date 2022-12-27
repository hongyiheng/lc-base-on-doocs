class Solution:
    def minimumMoves(self, s: str) -> int:
        n, i, ans = len(s), 0, 0
        while i < n:
            if s[i] == 'X':
                i += 3
                ans += 1
            else:
                i += 1
        return ans