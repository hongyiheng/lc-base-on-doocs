class Solution:
    def bestTeamScore(self, scores: List[int], ages: List[int]) -> int:
        nums = [(a, b) for a, b in zip(ages, scores)]
        nums.sort(key=lambda x: (x[0], x[1]))
        n = len(scores)
        dp = [0] * n
        dp[0] = nums[0][1]
        for i in range(1, n):
            mx = 0
            for j in range(i):
                if nums[j][1] <= nums[i][1]:
                    mx = max(mx, dp[j])
            dp[i] = mx + nums[i][1]
        return max(dp)