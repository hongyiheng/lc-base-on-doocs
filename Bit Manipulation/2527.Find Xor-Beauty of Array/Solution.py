class Solution:
    def xorBeauty(self, nums: List[int]) -> int:
        ans = 0
        for v in nums:
            ans ^= v
        return ans