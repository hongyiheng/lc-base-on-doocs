class Solution:
    def hasIncreasingSubarrays(self, nums: List[int], k: int) -> bool:
        n = len(nums)
        f = [1] * n
        for i in range(1, n):
            if nums[i - 1] < nums[i]:
                f[i] = f[i - 1] + 1
            if f[i] >= k and f[i - k] >= k:
                return True
        return False
