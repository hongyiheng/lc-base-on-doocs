class Solution:
    def addSpaces(self, s: str, spaces: List[int]) -> str:
        q = []
        last = 0
        for v in spaces:
            q.append(s[last:v])
            last = v
        if last != len(s):
            q.append(s[last:])
        return " ".join(q)
