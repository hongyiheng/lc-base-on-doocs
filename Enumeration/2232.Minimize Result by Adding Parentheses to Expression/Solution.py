class Solution:
    def minimizeResult(self, expression: str) -> str:
        l, r = expression.split("+")
        ans, mi = "(" + expression + ")", int(l) + int(r)
        for i in range(len(l)):
            for j in range(1, len(r) + 1):
                la, lb = int(l[:i]) if l[:i] else 1, int(l[i:]) if l[i:] else 1
                ra, rb = int(r[:j]) if r[:j] else 1, int(r[j:]) if r[j:] else 1
                v = la * (lb + ra) * rb
                if v < mi:
                    mi = v
                    ans = l[:i] + "(" + l[i:] + '+' + r[:j] + ')' + r[j:]
        return ans