class Solution:
    def waysToSplitArray(self, nums: List[int]) -> int:
        n = len(nums)
        pre = [0] * (n + 1)
        s = 0
        for i in range(n):
            pre[i + 1] = pre[i] + nums[i]
            s += nums[i]
        ans = 0
        for i in range(1, n):
            if pre[i] >= s - pre[i]:
                ans += 1
        return ans