class Solution:
    def maximumUniqueSubarray(self, nums: List[int]) -> int:
        n = len(nums)
        pre = [0] * (n + 1)
        pos = dict()
        ans = last = 0
        for i, v in enumerate(nums):
            pre[i + 1] = pre[i] + v
            if v in pos and pos[v] > last:
                last = pos[v]
            ans = max(ans, pre[i + 1] - pre[last])
            pos[v] = i + 1
        return ans