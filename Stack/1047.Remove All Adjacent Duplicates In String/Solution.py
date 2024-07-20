class Solution:
    def removeDuplicates(self, s: str) -> str:
        q = []
        for c in s:
            if q and q[-1] == c:
                q.pop()
                continue
            q.append(c)
        return "".join(q)