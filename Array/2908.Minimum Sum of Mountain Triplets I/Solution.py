class Solution:
    def minimumSum(self, nums: List[int]) -> int:
        n = len(nums)
        q = [inf] * n
        for i in range(1, n):
            q[i] = min(q[i - 1], nums[i - 1])
        ans = mi = inf
        for i in range(n - 2, -1, -1):
            mi = min(mi, nums[i + 1])
            if q[i] < nums[i] > mi:
                ans = min(ans, q[i] + nums[i] + mi)
        return -1 if ans == inf else ans