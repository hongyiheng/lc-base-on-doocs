class Solution:
    def reformat(self, s: str) -> str:
        q1, q2 = [], []
        for c in s:
            if '0' <= c <= '9':
                q1.append(c)
            else:
                q2.append(c)
        if abs(len(q1) - len(q2)) > 1:
            return ""
        ans = [q1.pop() if len(q1) >= len(q2) else q2.pop()]
        while q1 or q2:
            if '0' <= ans[-1] <= '9':
                ans.append(q2.pop())
            else:
                ans.append(q1.pop())
        return "".join(ans)