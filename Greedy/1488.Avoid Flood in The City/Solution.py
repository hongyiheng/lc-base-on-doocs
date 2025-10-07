class Solution:
    def avoidFlood(self, rains: List[int]) -> List[int]:
        n = len(rains)
        g = dict()
        ans = [0] * n
        for i in range(n - 1, -1, -1):
            if rains[i]:
                ans[i] = g.get(rains[i], 0)
                g[rains[i]] = i

        full = set()
        q = []
        for i, v in enumerate(rains):
            if v:
                if v in full:
                    return []
                if ans[i]:
                    heapq.heappush(q, ans[i])
                ans[i] = -1
                full.add(v)
            else:
                x = rains[heapq.heappop(q)] if q else 1
                if x in full:
                    full.remove(x)
                ans[i] = x
        return ans
