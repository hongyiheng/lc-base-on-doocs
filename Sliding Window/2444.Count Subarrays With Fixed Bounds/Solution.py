class Solution:
    def countSubarrays(self, nums: List[int], minK: int, maxK: int) -> int:
        l = r1 = r2 = -1
        ans = 0
        for i, v in enumerate(nums):
            if v < minK or v > maxK:
                l = i
            if v == minK:
                r1 = i
            if v == maxK:
                r2 = i
            ans += max(0, min(r1, r2) - l)
        return ans
