class Solution:
    def maxResult(self, nums: List[int], k: int) -> int:
        q = []
        for i, v in enumerate(nums):
            while q and i - q[0][1] > k:
                heapq.heappop(q)
            last = q[0][0] if q else 0
            if i == len(nums) - 1:
                return -(last - v)
            heapq.heappush(q, [last - v, i])
        return -1
