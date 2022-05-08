class Solution:
    def findDuplicates(self, nums: List[int]) -> List[int]:
        for i in range(len(nums)):
            while nums[i] - 1 != i:
                if nums[i] == nums[nums[i] - 1]:
                    break
                nums[nums[i] - 1], nums[i] = nums[i], nums[nums[i] - 1]
        ans = []
        for i, v in enumerate(nums):
            if v - 1 != i:
                ans.append(v)
        return ans