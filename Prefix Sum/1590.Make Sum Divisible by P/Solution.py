class Solution:
    def minSubarray(self, nums: List[int], p: int) -> int:
        ans, n = len(nums), len(nums)
        pre = [0] * (n + 1)
        k = sum(nums) % p
        for i in range(1, n + 1):
            pre[i] = (pre[i - 1] + nums[i - 1]) % p
        mp = {}
        for i in range(n + 1):
            mp[pre[i]] = i
            x = (pre[i] - k + p) % p
            if x in mp:
                ans = min(i - mp[x], ans)
        return -1 if ans == n else ans