class Solution:
    def countSubarrays(self, nums: List[int], minK: int, maxK: int) -> int:
        l = mi = mx = -1
        ans = 0
        for i, v in enumerate(nums):
            if v < minK or maxK < v:
                l = i
            if v == minK:
                mi = i
            if v == maxK:
                mx = i
            ans += max(0, min(mi, mx) - l)
        return ans
        