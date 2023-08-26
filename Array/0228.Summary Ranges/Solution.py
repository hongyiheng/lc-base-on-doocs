class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        ans = []
        i, n = 0, len(nums)
        while i < n:
            l = r = i
            while r + 1 < n and nums[r + 1] == nums[r] + 1:
                r += 1
            if l == r:
                ans.append(str(nums[i]))
            else:
                ans.append(str(nums[l]) + '->' + str(nums[r]))
            i = r + 1
        return ans
