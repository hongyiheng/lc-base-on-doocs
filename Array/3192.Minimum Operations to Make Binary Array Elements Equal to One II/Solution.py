class Solution:
    def minOperations(self, nums: List[int]) -> int:
        ans = 0
        f = False
        for v in nums:
            v = v if not f else v ^ 1
            if not v:
                ans += 1
                f = not f
        return ans