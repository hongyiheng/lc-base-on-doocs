class Solution:
    def findTheArrayConcVal(self, nums: List[int]) -> int:
        l, r = 0, len(nums) - 1
        ans = 0
        while l < r:
            ans += nums[l] * 10 ** (len(str(nums[r])))  + nums[r]
            l += 1
            r -= 1
        return ans + nums[r] if l == r else ans