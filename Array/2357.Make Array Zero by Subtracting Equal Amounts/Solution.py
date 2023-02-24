class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        return len(set([v for v in nums if v > 0]))
