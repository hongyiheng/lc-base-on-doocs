class Solution:
    def minimumCost(self, nums: List[int]) -> int:
        a = b = inf
        for i in range(1, len(nums)):
            if nums[i] < a:
                b = a
                a = nums[i]
            elif nums[i] < b:
                b = nums[i]
        return nums[0] + a + b

