class Solution:
    def findFinalValue(self, nums: List[int], original: int) -> int:
        cnt = [False] * 2001
        for v in nums:
            cnt[v] = True
        while cnt[original]:
            original *= 2
        return original