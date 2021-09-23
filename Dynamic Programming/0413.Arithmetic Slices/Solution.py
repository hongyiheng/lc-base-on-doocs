class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        n = len(nums)
        if n < 3:
            return 0
        mp = [0] * (n + 1)
        for i in range(1, n + 1):
            mp[i] = mp[i - 1] + i
        ans, diff, son_len = 0, nums[1] - nums[0], 1
        for i in range(2, n):
            if nums[i] - nums[i - 1] == diff:
                son_len += 1
            else:
                ans += mp[son_len - 1]
                diff = nums[i] - nums[i - 1]
                son_len = 1
        ans += mp[son_len - 1]
        return ans
