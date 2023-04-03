class Solution:
    def smallestEquivalentString(self, s1: str, s2: str, baseStr: str) -> str:
        p = [i for i in range(26)]

        def find(x):
            if p[x] != x:
                p[x] = find(p[x])
            return p[x]

        def union(a, b):
            if find(a) > find(b):
                p[find(a)] = find(b)
                return
            p[find(b)] = find(a)

        for o1, o2 in zip(s1, s2):
            if o1 != o2:
                union(ord(o1) - ord('a'), ord(o2) - ord('a'))
        cs = list(baseStr)
        for i, c in enumerate(cs):
            cs[i] = chr(find(ord(c) - ord('a')) + ord('a'))
        return "".join(cs)
