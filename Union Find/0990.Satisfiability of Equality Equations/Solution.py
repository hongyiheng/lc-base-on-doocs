class Solution:
    def equationsPossible(self, equations: List[str]) -> bool:
        p = [i for i in range(26)]

        def find(x):
            if p[x] != x:
                p[x] = find(p[x])
            return p[x]

        def union(a, b):
            r1, r2 = find(a), find(b)
            if r1 != r2:
                p[r1] = r2

        for s in equations:
            if s[1] == "=":
                union(ord(s[0]) - ord('a'), ord(s[3]) - ord('a'))
        for s in equations:
            if s[1] == '!' and find(ord(s[0]) - ord('a')) == find(ord(s[3]) - ord('a')):
                return False
        return True