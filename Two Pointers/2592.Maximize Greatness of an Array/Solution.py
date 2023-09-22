class Solution:
    def maximizeGreatness(self, nums: List[int]) -> int:
        nums.sort()
        n = len(nums)
        l = r = ans = 0
        while r < n:
            if nums[r] > nums[l]:
                ans += 1
                l += 1
            r += 1
        return ans
