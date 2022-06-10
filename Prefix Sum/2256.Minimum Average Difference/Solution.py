class Solution:
    def minimumAverageDifference(self, nums: List[int]) -> int:
        n = len(nums)
        pre = [0] * (n + 1)
        for i in range(n):
            pre[i + 1] = pre[i] + nums[i]
        ans, cur = 0, float('inf')
        for i in range(n):
            pre_avg = pre[i + 1] // (i + 1)
            tail_avg = 0 if (n - i - 1) == 0 else (pre[n] - pre[i + 1]) // (n - i - 1)
            diff = abs(pre_avg - tail_avg)
            if diff < cur:
                cur = diff
                ans = i
        return ans