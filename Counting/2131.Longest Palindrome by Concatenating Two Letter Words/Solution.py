class Solution:
    def longestPalindrome(self, words: List[str]) -> int:
        g = [[0] * 26 for _ in range(26)]
        ans = 0
        for w in words:
            i, j = ord(w[0]) - ord('a'), ord(w[1]) - ord('a')
            if g[j][i]:
                ans += 4
                g[j][i] -= 1
            else:
                g[i][j] += 1
        for i in range(26):
            if g[i][i]:
                return ans + 2
        return ans