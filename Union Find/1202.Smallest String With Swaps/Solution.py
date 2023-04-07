class Solution:
    def smallestStringWithSwaps(self, s: str, pairs: List[List[int]]) -> str:
        def find(x):
            if p[x] != x:
                p[x] = find(p[x])
            return p[x]

        def union(a, b):
            p[find(a)] = find(b)

        n = len(s)
        p = [i for i in range(n)]
        for a, b in pairs:
            union(a, b)
        g = dict()
        for i in range(n):
            cnt = g.get(find(i), [0] * 26)
            cnt[ord(s[i]) - ord('a')] += 1
            if find(i) not in g:
                g[find(i)] = cnt
        ans = []
        for i in range(n):
            for j in range(26):
                if g[find(i)][j]:
                    ans.append(chr(ord('a') + j))
                    g[find(i)][j] -= 1
                    break
        return "".join(ans)
