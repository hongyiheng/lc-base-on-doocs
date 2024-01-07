class Solution:
    def minOperations(self, nums: List[int]) -> int:
        cnt = Counter(nums)
        if 1 in cnt.values():
            return -1
        return sum([(c + 2) // 3 for c in cnt.values()])
