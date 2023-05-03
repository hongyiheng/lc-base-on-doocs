class Solution:
    def isValid(self, s: str) -> bool:
        if len(s) % 3:
            return False
        q = []
        for c in s:
            q.append(c)
            if len(q) >= 3 and "".join(q[-3:]) == 'abc':
                for _ in range(3):
                    q.pop()
        return not q