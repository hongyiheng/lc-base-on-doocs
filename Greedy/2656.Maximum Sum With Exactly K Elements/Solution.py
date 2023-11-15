class Solution:
    def maximizeSum(self, nums: List[int], k: int) -> int:
        v = max(nums)
        return (v + k - 1 + v) * k // 2