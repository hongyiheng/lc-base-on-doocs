class Solution:
    def maxSumDistinctTriplet(self, x: List[int], y: List[int]) -> int:
        g = dict()
        for i, v in enumerate(x):
            if g.get(v, -1) < y[i]:
                g[v] = y[i]
        a = b = c = -1
        for v in g.values():
            if v >= a:
                c = b
                b = a
                a = v
            elif v >= b:
                c = b
                b = v
            elif v >= c:
                c = v
        return -1 if c == -1 else a + b + c

