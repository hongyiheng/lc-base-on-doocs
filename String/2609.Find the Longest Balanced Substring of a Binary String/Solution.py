class Solution:
    def findTheLongestBalancedSubstring(self, s: str) -> int:
        a = b = ans = 0
        for c in s:
            if c == '0':
                if b:
                    a = b = 0
                a += 1
            else:
                b += 1
                ans = max(ans, 2 * min(a, b))
        return ans