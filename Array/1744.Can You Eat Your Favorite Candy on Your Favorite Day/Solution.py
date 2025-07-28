class Solution:
    def canEat(self, candiesCount: List[int], queries: List[List[int]]) -> List[bool]:
        n = len(candiesCount)
        scope = [[0] * 2 for _ in range(n)]
        s = 0
        for i, v in enumerate(candiesCount):
            scope[i][0] = s + 1
            s += v
            scope[i][1] = s
        ans = []
        for t, d, c in queries:
            l, r = scope[t]
            ans.append((d + 1) * c >= l and d + 1 <= r)
        return ans