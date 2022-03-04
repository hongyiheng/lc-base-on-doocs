class Solution:
    def subArrayRanges(self, nums: List[int]) -> int:
        n = len(nums)
        ans = 0
        for i in range(n):
            max_num = min_num = nums[i]
            for j in range(i + 1, n):
                max_num = max(max_num, nums[j])
                min_num = min(min_num, nums[j])
                ans += max_num - min_num
        return ans
