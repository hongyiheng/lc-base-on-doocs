class Solution:
    def isZeroArray(self, nums: List[int], queries: List[List[int]]) -> bool:
        q = [0] * (len(nums) + 2)
        for l, r in queries:
            q[l] += 1
            q[r + 1] -= 1
        d = 0
        for i, v in enumerate(nums):
            d += q[i]
            if v > d:
                return False
        return True
