class Solution:
    def calculateScore(self, s: str) -> int:
        idx = [[] for _ in range(26)]
        ans = 0
        for i, c in enumerate(list(s)):
            v = ord(c) - ord('a')
            t = 25 - v
            if idx[t]:
                ans += i - idx[t].pop()
            else:
                idx[v].append(i)
        return ans