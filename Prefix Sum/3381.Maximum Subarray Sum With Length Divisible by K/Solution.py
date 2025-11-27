class Solution:
    def maxSubarraySum(self, nums: List[int], k: int) -> int:
        n = len(nums)
        s = 0
        pre = [inf] * k
        pre[0] = 0
        ans = -inf
        for i in range(n):
            s += nums[i]
            mod = (i + 1) % k
            if pre[mod] != inf:
                ans = max(ans, s - pre[mod])
            pre[mod] = min(pre[mod], s)
        return ans

