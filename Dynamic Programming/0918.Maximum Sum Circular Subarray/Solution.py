class Solution:
    def maxSubarraySumCircular(self, nums: List[int]) -> int:
        mx, mi = -inf, inf
        ans = s = sum(nums)
        for i, v in enumerate(nums):
            mx = max(v, mx + v)
            mi = min(v, mi + v)
            if mi == s and i == len(nums) - 1:
                mi = inf
            ans = max(s - mi, mx, ans)
        return ans