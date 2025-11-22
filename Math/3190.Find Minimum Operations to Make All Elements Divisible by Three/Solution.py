class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        return sum([min(v % 3, 3 - v % 3) for v in nums])