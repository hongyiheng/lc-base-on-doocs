class Solution:
    def partitionDisjoint(self, nums: List[int]) -> int:
        n = len(nums)
        min_val, min_idx = nums[0], 0
        for i, v in enumerate(nums):
            if v < min_val:
                min_val = v
                min_idx = i
        max_val = max(nums[:min_idx + 1])
        next_max = max_val
        ans = min_idx + 1
        for i in range(min_idx + 1, n):
            if nums[i] < max_val:
                max_val = next_max
                ans = i + 1
            next_max = max(nums[i], next_max)
        return ans
