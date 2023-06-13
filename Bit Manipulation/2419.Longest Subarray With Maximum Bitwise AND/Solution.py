class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        mx = cur = ans = 0
        for i, v in enumerate(nums):
            if v > mx:
                cur = ans = 1
                mx = v
            elif v == mx:
                cur += 1
            else:
                cur = 0
            ans = max(ans, cur)
        return ans
