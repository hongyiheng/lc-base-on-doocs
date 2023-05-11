class Solution:
    def minPatches(self, nums: List[int], n: int) -> int:
        ans = idx = 0
        cur = 1
        while cur <= n:
            if idx < len(nums) and nums[idx] <= cur:
                cur += nums[idx]
                idx += 1
            else:
                cur *= 2
                ans += 1
        return ans
