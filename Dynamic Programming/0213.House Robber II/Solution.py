class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1:
            return nums[0]
        dp1 = [[0] * 2 for _ in range(n + 1)]
        for i in range(1, n):
            dp1[i][0] = max(dp1[i - 1][0], dp1[i - 1][1])
            dp1[i][1] = dp1[i - 1][0] + nums[i - 1]
        dp2 = [[0] * 2 for _ in range(n + 1)]
        for i in range(2, n + 1):
            dp2[i][0] = max(dp2[i - 1][0], dp2[i - 1][1])
            dp2[i][1] = dp2[i - 1][0] + nums[i - 1]
        return max(max(dp1[n - 1][0], dp1[n - 1][1]), max(dp2[n][0], dp2[n][1]))