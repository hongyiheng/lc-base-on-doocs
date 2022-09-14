class Solution:
    def maxSubArrayLen(self, nums: List[int], k: int) -> int:
        n = len(nums)
        pre = [0] * (n + 1)
        mp = dict()
        for i in range(n):
            pre[i + 1] = pre[i] + nums[i]
            if pre[i + 1] not in mp:
                mp[pre[i + 1]] = i
        ans = 0
        for i in range(n):
            cur = pre[i + 1]
            if cur == k:
                ans = max(ans, i + 1)
                continue
            j = mp.get(cur - k, -1)
            if j != -1 and j < i:
                ans = max(ans, i - j)
        return ans