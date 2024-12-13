class Solution:
    def getFinalState(self, nums: List[int], k: int, multiplier: int) -> List[int]:
        q = [[v, i] for i, v in enumerate(nums)]
        heapq.heapify(q)
        for _ in range(k):
            v, i = heapq.heappop(q)
            heapq.heappush(q, [v * multiplier, i])
        q.sort(key=lambda x: x[1])
        return [v for v, _ in q]
