class Solution:
    def minCost(self, nums: List[int], cost: List[int]) -> int:
        nc = sorted(zip(nums, cost))
        ans = cur = sum((x - nc[0][0]) * c for x, c in nc)
        left, right = 0, sum(cost)
        for i in range(1, len(nc)):
            left += nc[i - 1][1]
            right -= nc[i - 1][1]
            diff = nc[i][0] - nc[i - 1][0]
            cur += left * diff - right * diff
            ans = min(ans, cur)
        return ans
