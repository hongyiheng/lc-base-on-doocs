class Solution:
    def twoSumLessThanK(self, nums: List[int], k: int) -> int:
        ans, n = -1, len(nums)
        for i in range(n):
            for j in range(i + 1, n):
                if nums[i] + nums[j] < k:
                    ans = max(nums[i] + nums[j], ans)
        return ans