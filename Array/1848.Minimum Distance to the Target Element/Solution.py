class Solution:
    def getMinDistance(self, nums: List[int], target: int, start: int) -> int:
        ans = inf
        for i, v in enumerate(nums):
            if v == target:
                ans = min(ans, abs(i - start))
        return ans