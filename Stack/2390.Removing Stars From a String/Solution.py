class Solution:
    def removeStars(self, s: str) -> str:
        q = deque()
        for c in s:
            if c == '*':
                q.pop()
            else:
                q.append(c)
        return "".join(q)
