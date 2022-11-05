class Solution:
    def parseBoolExpr(self, expression: str) -> bool:
        cs = {'t', 'f', '&', '|', "!"}
        q = []
        for c in expression:
            if c in cs or c in cs:
                q.append(c)
                continue
            if c == ')':
                t = f = 0
                while q[-1] in {'t', 'f'}:
                    if q[-1] == 't':
                        t += 1
                    if q[-1] == 'f':
                        f += 1
                    q.pop()
                v = 'f'
                c = q.pop()
                if (c == '&' and f == 0) or (c == '!' and f > 0) or (c == '|' and t > 0):
                    v = 't'
                q.append(v)
        return True if q.pop() == 't' else False
