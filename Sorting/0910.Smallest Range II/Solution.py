class Solution:
    def smallestRangeII(self, nums: List[int], k: int) -> int:
        nums.sort()
        mi, mx = nums[0], nums[-1]
        ans = mx - mi
        for i in range(len(nums) - 1):
            a, b = nums[i], nums[i + 1]
            ans = min(ans, max(mx - k, a + k) - min(mi + k, b - k))
        return ans