class Solution:
    def longestNiceSubarray(self, nums: List[int]) -> int:
        l = r = ans = msk = 0
        while r < len(nums):
            while msk & nums[r] != 0:
                msk ^= nums[l]
                l += 1
            msk |= nums[r]
            ans = max(ans, r - l + 1)
            r += 1
        return ans