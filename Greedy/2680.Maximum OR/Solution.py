class Solution:
    def maximumOr(self, nums: List[int], k: int) -> int:
        n = len(nums)
        suf = [0] * (n + 1)
        for i in range(n - 1, -1, -1):
            suf[i] = suf[i + 1] | nums[i]
        ans = pre = 0
        for i, v in enumerate(nums):
            ans = max(ans, pre | nums[i] << k | suf[i + 1])
            pre |= nums[i]
        return ans