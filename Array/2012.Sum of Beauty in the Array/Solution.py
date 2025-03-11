class Solution:
    def sumOfBeauties(self, nums: List[int]) -> int:
        n = len(nums)
        q = [[0] * 2 for _ in range(n)]
        for i in range(len(nums)):
            q[i][0] = nums[i]
            if i:
                q[i][0] = max(q[i - 1][0], q[i][0])
            q[n - i - 1][1] = nums[n - i - 1]
            if n - i <= n - 1:
                q[n - i - 1][1] = min(q[n - i][1], q[n - i - 1][1])
        ans = 0
        for i in range(1, n - 1):
            if q[i - 1][0] < nums[i] < q[i + 1][1]:
                ans += 2
            elif nums[i - 1] < nums[i] < nums[i + 1]:
                ans += 1
        return ans



