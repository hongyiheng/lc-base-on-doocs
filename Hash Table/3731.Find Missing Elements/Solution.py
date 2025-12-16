class Solution:
    def findMissingElements(self, nums: List[int]) -> List[int]:
        s = set(nums)
        return [i for i in range(min(s) + 1, max(s)) if i not in s]