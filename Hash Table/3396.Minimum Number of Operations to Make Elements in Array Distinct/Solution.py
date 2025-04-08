class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        n = len(nums)
        s = set()
        for i in range(n - 1, -1, -1):
            if nums[i] in s:
                return i // 3 + 1
            s.add(nums[i])
        return 0
