class Solution:
    def countAlternatingSubarrays(self, nums: List[int]) -> int:
        ans = cur = 1
        for i in range(1, len(nums)):
            if nums[i - 1] != nums[i]:
                cur += 1
            else:
                cur = 1
            ans += cur
        return ans