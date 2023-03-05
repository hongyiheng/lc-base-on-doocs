class Solution:
    def leftRigthDifference(self, nums: List[int]) -> List[int]:
        n = len(nums)
        pre = [0] * (n + 1)
        s = 0
        for i in range(n):
            pre[i + 1] = pre[i] + nums[i]
            s += nums[i]
        ans = [0] * n
        for i in range(n):
            ans[i] = abs(pre[i] - (s - pre[i + 1]))
        return ans