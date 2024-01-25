class Solution:
    def sumIndicesWithKSetBits(self, nums: List[int], k: int) -> int:
        return sum(v for i, v in enumerate(nums) if i.bit_count() == k)
