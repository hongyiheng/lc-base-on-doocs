class Solution:
    def addSpaces(self, s: str, spaces: List[int]) -> str:
        ans = []
        last = 0
        for v in spaces:
            ans.append(s[last:v])
            last = v
        ans.append(s[last:])
        return " ".join(ans)
