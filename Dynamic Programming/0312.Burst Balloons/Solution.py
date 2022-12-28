class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        n = len(nums)
        nums = [1] + nums + [1]
        f = [[0] * (n + 2) for _ in range(n + 2)]
        for m in range(3, n + 3):
            for i in range(n + 2):
                j = i + m - 1
                if j > n + 1:
                    break
                for k in range(i + 1, j):
                    f[i][j] = max(f[i][j], f[i][k] + f[k][j] + nums[i] * nums[k] * nums[j])
        return f[0][n + 1]