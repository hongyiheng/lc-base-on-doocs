class Solution:
    def minOperationsToMakeMedianK(self, nums: List[int], k: int) -> int:
        n = len(nums)
        nums.sort()
        ans = 0
        for i in range(n):
            if i < n // 2:
                ans += max(nums[i] - k, 0)
            elif i == n // 2:
                ans += abs(nums[i] - k)
            else:
                ans += max(k - nums[i], 0)
        return ans