class Solution:
    def increasingTriplet(self, nums: List[int]) -> bool:
        n, ans = len(nums), 1
        dp = [float('inf')] * (n + 1)
        for i in range(n):
            cur = nums[i]
            l, r = 1, i + 1
            while l < r:
                mid = (l + r) >> 1
                if dp[mid] >= cur:
                    r = mid
                else:
                    l = mid + 1
            dp[r] = cur
            ans = max(ans, r)
        return ans >= 3