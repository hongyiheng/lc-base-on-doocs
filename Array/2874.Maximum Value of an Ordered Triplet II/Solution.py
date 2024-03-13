class Solution:
    def maximumTripletValue(self, nums: List[int]) -> int:
        n = len(nums)
        q = [0] * n
        for i in range(1, n):
            q[i] = max(q[i - 1], nums[i - 1])
        ans = mx = 0
        for i in range(n - 2, -1, -1):
            mx = max(mx, nums[i + 1])
            ans = max(ans, (q[i] - nums[i]) * mx)
        return ans