class Solution:
    def applyOperations(self, nums: List[int]) -> List[int]:
        n = len(nums)
        ans = [0] * n
        idx = 0
        for i, v in enumerate(nums):
            if v == 0:
                continue
            if i + 1 < n and nums[i + 1] == v:
                nums[i] += v
                nums[i + 1] = 0
            ans[idx] = nums[i]
            idx += 1
        return ans
