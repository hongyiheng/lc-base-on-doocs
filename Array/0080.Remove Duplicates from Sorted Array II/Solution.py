class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        n = len(nums)
        j = ans = 0
        for i in range(n):
            if j >= 2 and nums[j - 2] == nums[i]:
                continue
            nums[j] = nums[i]
            ans += 1
            j += 1
        return ans
