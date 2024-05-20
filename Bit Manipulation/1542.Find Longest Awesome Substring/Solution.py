class Solution:
    def longestAwesome(self, s: str) -> int:
        n = len(s)
        pos = [n] * (1 << 10)
        pos[0] = -1
        ans = pre = 0
        for i, c in enumerate(s):
            v = int(c)
            pre ^= 1 << v
            ans = max(ans, i - pos[pre], max([i - pos[pre ^ 1 << d] for d in range(10)]))
            if pos[pre] == n:
                pos[pre] = i
        return ans