class Solution:
    def dominantIndex(self, nums: List[int]) -> int:
        a, b, ans = 0, 0, 0
        for i, v in enumerate(nums):
            if v > a:
                a, b = v, a
                ans = i
            elif v > b:
                b = v
        return ans if a >= 2 * b else -1