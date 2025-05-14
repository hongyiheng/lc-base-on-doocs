class Solution:
    def uniqueXorTriplets(self, nums: List[int]) -> int:
        n = len(nums)
        if n <= 2:
            return n
        for i in range(16, -1, -1):
            if n >> i & 1:
                return 1 << (i + 1)
        return -1
