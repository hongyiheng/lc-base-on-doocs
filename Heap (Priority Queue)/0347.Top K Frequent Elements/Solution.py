class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        cnt = collections.Counter(nums)
        q = []
        for v, c in cnt.items():
            if len(q) < k:
                heapq.heappush(q, [c, v])
            else:
                if q[0][0] < c:
                    heapq.heappop(q)
                    heapq.heappush(q, [c, v])
        return [v[1] for v in q]

