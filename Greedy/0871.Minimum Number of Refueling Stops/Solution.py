class Solution:
    def minRefuelStops(self, target: int, startFuel: int, stations: List[List[int]]) -> int:
        q = []
        f, ans = startFuel, 0
        for v in stations:
            if f >= target:
                return ans
            while q and f < v[0]:
                f += -heapq.heappop(q)
                ans += 1
            if f >= v[0]:
                heapq.heappush(q, -v[1])
            else:
                return -1
        while f < target and q:
            f += -heapq.heappop(q)
            ans += 1
        return ans if f >= target else -1
