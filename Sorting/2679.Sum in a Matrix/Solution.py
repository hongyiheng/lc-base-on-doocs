class Solution:
    def matrixSum(self, nums: List[List[int]]) -> int:
        for row in nums:
            row.sort()
        m, n = len(nums), len(nums[0])
        ans = 0
        for j in range(n):
            mx = 0
            for i in range(m):
                mx = max(mx, nums[i][j])
            ans += mx
        return ans
