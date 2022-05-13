class Solution:
    def minSwapsCouples(self, row: List[int]) -> int:
        n = len(row)
        m = n >> 1
        p = [i for i in range(m)]

        def find(x):
            if p[x] != x:
                p[x] = find(p[x])
            return p[x]

        def union(a, b):
            r1, r2 = find(a), find(b)
            if r1 != r2:
                p[r1] = r2

        for i in range(0, n, 2):
            union(row[i] >> 1, row[i + 1] >> 1)
        cnt = 0
        for i, v in enumerate(p):
            if i == v:
                cnt += 1
        return m - cnt