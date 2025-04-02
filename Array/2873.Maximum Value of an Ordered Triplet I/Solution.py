class Solution:
    def maximumTripletValue(self, nums: List[int]) -> int:
        n = len(nums)
        f = [0] * (n + 1)
        for i in range(n - 1, -1, -1):
            f[i] = max(nums[i], f[i + 1])
        ans = 0
        mx = nums[0]
        for i, v in enumerate(nums):
            ans = max((mx - v) * f[i + 1], ans)
            mx = max(mx, v)
        return ans