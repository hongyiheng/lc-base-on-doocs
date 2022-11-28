class Solution:
    def largestSumOfAverages(self, nums: List[int], k: int) -> float:
        n = len(nums)
        pre = [0] * (n + 10)
        for i in range(1, n + 1):
            pre[i] = pre[i - 1] + nums[i - 1]
        f = [[0] * (k + 10) for _ in range(n + 10)]
        for i in range(1, n + 1):
            for j in range(1, min(i, k) + 1):
                if j == 1:
                    f[i][j] = pre[i] / i
                    continue
                for t in range(2, i + 1):
                    f[i][j] = max(f[i][j], f[t - 1][j - 1] + (pre[i] - pre[t - 1]) / (i - t + 1))
        return f[n][k]
