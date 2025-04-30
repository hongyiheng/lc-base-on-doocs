class Solution:
    def findNumbers(self, nums: List[int]) -> int:
        return len([v for v in nums if len(str(v)) % 2 == 0])
        