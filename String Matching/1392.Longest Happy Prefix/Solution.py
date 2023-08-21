class Solution:
    def longestPrefix(self, s: str) -> str:
        nxt = [0]
        x, now = 1, 0
        while x < len(s):
            if s[now] == s[x]:
                now += 1
                x += 1
                nxt.append(now)
            elif now:
                now = nxt[now - 1]
            else:
                nxt.append(0)
                x += 1
        return s[:nxt[len(s) - 1]]