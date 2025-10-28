class Solution:
    def countValidSelections(self, nums: List[int]) -> int:
        s = sum(nums)
        cur = ans = 0
        for i, v in enumerate(nums):
            cur += v
            if (cur == s // 2 or cur == (s + 1) // 2) and not v:
                ans += 1 if s % 2 else 2
        return ans