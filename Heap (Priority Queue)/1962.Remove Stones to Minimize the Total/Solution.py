class Solution:
    def minStoneSum(self, piles: List[int], k: int) -> int:
        q = []
        ans = 0
        for v in piles:
            heapq.heappush(q, -v)
            ans += v
        for _ in range(k):
            v = -heapq.heappop(q)
            nv = (v + 1) // 2
            ans -= (v - nv)
            heapq.heappush(q, -nv)
        return int(ans)