class Solution:
    def countAsterisks(self, s: str) -> int:
        ans = cur = 0
        mid = False
        for c in s:
            if c == '*':
                cur += 1
            if c == '|':
                if not mid:
                    ans += cur
                mid = not mid
                cur = 0
        return ans + cur