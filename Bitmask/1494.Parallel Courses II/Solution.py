class Solution:
    def minNumberOfSemesters(self, n: int, relations: List[List[int]], k: int) -> int:
        @cache
        def dfs(x):
            if x == (1 << n) - 1:
                return 0
            nx = 0
            for i, mask in enumerate(g):
                if x & mask == mask:
                    nx |= (1 << i)
            nx ^= x
            res = n
            if nx.bit_count() <= k:
                res = dfs(nx | x) + 1
            else:
                msk = nx
                while msk:
                    if msk.bit_count() == k:
                        res = min(res, dfs(msk | x) + 1)
                    msk = (msk - 1) & nx
            return res

        g = [0] * (n)
        for u, v in relations:
            g[v - 1] |= (1 << (u - 1))
        return dfs(0)
