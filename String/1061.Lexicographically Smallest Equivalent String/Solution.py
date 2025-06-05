class Solution:
    def smallestEquivalentString(self, s1: str, s2: str, baseStr: str) -> str:
        def find(x):
            if p[x] != x:
                p[x] = find(p[x])
            return p[x]

        def union(a, b):
            r1, r2 = find(a), find(b)
            if r1 > r2:
                p[r1] = r2
            else:
                p[r2] = r1

        p = [i for i in range(26)]
        for a, b in zip(s1, s2):
            if a != b:
                union(ord(a) - ord('a'), ord(b) - ord('a'))
        cs = list(baseStr)
        for i, c in enumerate(cs):
            cs[i] = chr(find(ord(c) - ord('a')) + ord('a'))
        return "".join(cs)
