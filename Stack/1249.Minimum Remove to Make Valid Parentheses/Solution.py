class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        l = r = 0
        for c in s:
            if c == ')':
                r += 1
        q = []
        for c in s:
            if c == '(':
                if r - l <= 0:
                    continue
                l += 1
            elif c == ')':
                r -= 1
                if l == 0:
                    continue
                l -= 1
            q.append(c)
        return "".join(q)