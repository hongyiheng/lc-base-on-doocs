class Solution:
    def minRemoval(self, nums: List[int], k: int) -> int:
        nums.sort()
        l = ans = 0
        for r, v in enumerate(nums):
            while v > nums[l] * k:
                l += 1
            ans = max(ans, r - l + 1)
        return len(nums) - ans
