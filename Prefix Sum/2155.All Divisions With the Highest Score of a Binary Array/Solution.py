class Solution:
    def maxScoreIndices(self, nums: List[int]) -> List[int]:
        n = len(nums)
        pre = [[0] * 2 for _ in range(n + 1)]
        for i in range(n):
            pre[i + 1][0] = pre[i][0]
            pre[i + 1][1] = pre[i][1]
            if nums[i] == 0:
                pre[i + 1][0] += 1
            else:
                pre[i + 1][1] += 1
        ans = []
        mx = 0
        for i in range(n + 1):
            cur = pre[i][0] + pre[n][1] - pre[i][1]
            if cur > mx:
                mx = cur
                ans = [i]
            elif cur == mx:
                ans.append(i)
        return ans