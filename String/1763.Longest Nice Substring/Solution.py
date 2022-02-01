class Solution:
    def longestNiceSubstring(self, s: str) -> str:
        def check(son):
            up, low = [0] * 26, [0] * 26
            for c in son:
                if 'a' <= c and 'z' >= c:
                    low[ord(c) - ord('a')] += 1
                else:
                    up[ord(c) - ord('A')] += 1
            for i in range(26):
                if up[i] > 0 or low[i] > 0:
                    if up[i] > 0 and low[i] > 0:
                        continue
                    return False
            return True

        n = len(s)
        ans = ''
        for i in range(n):
            for j in range(i + 1, n):
                if len(ans) < j - i + 1 and check(s[i:j + 1]):
                    ans = s[i:j + 1]
        return ans