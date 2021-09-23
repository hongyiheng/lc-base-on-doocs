class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        n = len(nums)
        if n < 3:
            return 0
        dict = [0] * (n + 1)
        for i in range(1, n + 1):
            dict[i] = dict[i - 1] + i
        ans = 0
        diff = nums[1] - nums[0]
        sonLen = 1
        for i in range(2, n):
            if nums[i] - nums[i - 1] == diff:
                sonLen += 1
            else:
                ans += dict[sonLen - 1]
                diff = nums[i] - nums[i - 1]
                sonLen = 1
        ans += dict[sonLen - 1]
        return ans
