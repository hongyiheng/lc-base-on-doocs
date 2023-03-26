class Solution:
    def findClosestNumber(self, nums: List[int]) -> int:
        ans, gap = nums[0], abs(nums[0])
        for v in nums:
            if abs(v) < gap:
                gap = abs(v)
                ans = v
            elif abs(v) == gap and v > ans:
                ans = v
        return ans