class Solution:
    def longestArithSeqLength(self, nums: List[int]) -> int:
        ans, n = 0, len(nums)
        f = [[1] * 1010 for _ in range(n + 1)]
        for i in range(1, n):
            for j in range(i):
                k = nums[i] - nums[j] + 500
                f[i][k] = max(f[i][k], f[j][k] + 1)
                ans = max(f[i][k], ans)
        return ans