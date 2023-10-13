class Solution:
    def avoidFlood(self, rains: List[int]) -> List[int]:
        n = len(rains)
        ans = [0] * n
        g = dict()
        for i in range(n - 1, -1, -1):
            if rains[i]:
                ans[i] = g.get(rains[i], 0)
                g[rains[i]] = i
        s = set()
        q = []
        for i, v in enumerate(ans):
            if rains[i]:
                if rains[i] in s:
                    return []
                if ans[i]:
                    heapq.heappush(q, ans[i])
                ans[i] = -1
                s.add(rains[i])
            else:
                x = rains[heapq.heappop(q)] if q else 1
                ans[i] = x
                if x in s:
                    s.remove(x)
        return ans