class Solution:
    def findNumberOfLIS(self, nums: List[int]) -> int:
        n = len(nums)
        dp, cnt = [1] * n, [1] * n
        mx = 1
        for i in range(1, n):
            for j in range(i):
                if nums[i] > nums[j]:
                    if dp[i] < dp[j] + 1:
                        dp[i] = dp[j] + 1
                        cnt[i] = cnt[j]
                    elif dp[i] == dp[j] + 1:
                        cnt[i] += cnt[j]
            mx = max(mx, dp[i])
        ans = 0
        for i in range(n):
            if dp[i] == mx:
                ans += cnt[i]
        return ans