class Solution:
    def maxWidthRamp(self, nums: List[int]) -> int:
        q = []
        for i, v in enumerate(nums):
            if not q or q[-1][1] > v:
                q.append((i, v))
        ans, n = 0, len(nums)
        for j in range(n - 1, -1, -1):
            while q and q[-1][0] >= j:
                q.pop()
            while q and q[-1][1] <= nums[j]:
                ans = max(ans, j - q.pop()[0])
        return ans