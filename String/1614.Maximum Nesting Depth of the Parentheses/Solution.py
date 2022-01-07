class Solution:
    def maxDepth(self, s: str) -> int:
        cur, ans = 0, 0
        for c in s:
            if c == '(':
                cur += 1
            elif c == ')':
                cur -= 1
            ans = max(cur, ans)
        return ans