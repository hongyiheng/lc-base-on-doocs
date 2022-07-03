class Solution:
    def triangularSum(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1:
            return nums[0]
        if n == 2:
            return (nums[0] + nums[1]) % 10
        ans = [0] * n
        r = n - 1
        while r > 1:
            for i in range(r):
                ans[i] = (nums[i] + nums[i + 1]) % 10
            for i in range(r):
                nums[i] = ans[i]
            r -= 1
        return (ans[0] + ans[1]) % 10