class Solution:
    def minElement(self, nums: List[int]) -> int:
        ans = nums[0]
        for v in nums:
            s = 0
            while v:
                s += v % 10
                v //= 10
            ans = min(ans, s)
        return ans