class Solution:
    def reverseParentheses(self, s: str) -> str:
        q = []
        for c in s:
            if c == ')':
                tmp = []
                v = q.pop()
                while v != '(':
                    tmp.append(v)
                    v = q.pop()
                q.extend(tmp)
            else:
                q.append(c)
        return "".join(q)