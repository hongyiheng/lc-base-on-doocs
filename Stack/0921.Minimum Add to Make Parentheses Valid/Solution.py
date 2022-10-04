class Solution:
    def minAddToMakeValid(self, s: str) -> int:
        q = deque()
        for c in s:
            if c == ')':
                if q and q[-1] == '(':
                    q.pop()
                    continue
            q.append(c)
        return len(q)
