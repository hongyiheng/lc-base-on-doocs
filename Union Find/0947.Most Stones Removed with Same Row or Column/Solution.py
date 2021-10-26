class Solution:
    def removeStones(self, stones: List[List[int]]) -> int:
        m = len(stones)
        p = [i for i in range(m)]

        def find(x):
            if p[x] != x:
                p[x] = find(p[x])
            return p[x]

        count = m
        for i in range(m - 1):
            for j in range(i + 1, m):
                if stones[i][0] == stones[j][0] or stones[i][1] == stones[j][1]:
                    r1 = find(i)
                    r2 = find(j)
                    if r1 != r2:
                        p[r1] = r2
                        count -= 1
        return m - count