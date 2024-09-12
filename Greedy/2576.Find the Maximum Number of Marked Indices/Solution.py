class Solution:
    def maxNumOfMarkedIndices(self, nums: List[int]) -> int:
        nums.sort()
        n, l = len(nums), 0
        for i in range((n + 1) // 2, n):
            if nums[l] * 2 <= nums[i]:
                l += 1
        return l * 2