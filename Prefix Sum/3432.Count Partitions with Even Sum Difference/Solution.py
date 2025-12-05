class Solution:
    def countPartitions(self, nums: List[int]) -> int:
        r = sum(nums)
        ans = l = 0
        for v in nums[:-1]:
            l += v
            r -= v
            if not (r - l) % 2:
                ans += 1
        return ans