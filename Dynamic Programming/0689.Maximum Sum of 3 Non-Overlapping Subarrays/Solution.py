class Solution:
    def maxSumOfThreeSubarrays(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        pre = [0] * (n + 1)
        for i in range(1, n + 1):
            pre[i] = pre[i - 1] + nums[i - 1]
        dp = [[0 for _ in range(4)] for _ in range(n + 1)]
        for i in range(k, n + 1):
            s = pre[i] - pre[i - k]
            for j in range(1, 4):
                dp[i][j] = max(dp[i - 1][j], dp[i - k][j - 1] + s)
        index, ans = n, [0] * 3
        for i in range(2, -1, -1):
            while dp[index - 1][i + 1] >= dp[index][i + 1]:
                index -= 1
            ans[i] = index - k
            index -= k
        return ans