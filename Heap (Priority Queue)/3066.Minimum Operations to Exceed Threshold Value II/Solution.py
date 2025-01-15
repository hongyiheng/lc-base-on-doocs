class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        ans = 0
        heapq.heapify(nums)
        while len(nums) >= 2 and nums[0] < k:
            a, b = heapq.heappop(nums), heapq.heappop(nums)
            heapq.heappush(nums, a * 2 + b)
            ans += 1
        return ans
