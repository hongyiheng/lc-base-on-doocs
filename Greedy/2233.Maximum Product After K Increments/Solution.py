class Solution:
    def maximumProduct(self, nums: List[int], k: int) -> int:
        heapq.heapify(nums)
        while k:
            v = heapq.heappop(nums)
            heapq.heappush(nums, v + 1)
            k -= 1
        ans, mod = 1, int(1e9 + 7)
        for v in nums:
            ans = ans * v % mod
        return ans