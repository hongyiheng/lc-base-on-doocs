class Solution:
    def clearDigits(self, s: str) -> str:
        ans = []
        for c in s:
            if '0' <= c <= '9':
                if ans:
                    ans.pop()
            else:
                ans.append(c)
        return "".join(ans)
