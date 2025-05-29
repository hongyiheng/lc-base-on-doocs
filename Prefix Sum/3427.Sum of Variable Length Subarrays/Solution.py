class Solution:
    def subarraySum(self, nums: List[int]) -> int:
        n = len(nums)
        pre = [0] * (n + 1)
        for i, v in enumerate(nums):
            pre[i + 1] = pre[i] + v
        ans = 0
        for i, v in enumerate(nums):
            ans += pre[i + 1] - pre[max(0, i - v)]
        return ans