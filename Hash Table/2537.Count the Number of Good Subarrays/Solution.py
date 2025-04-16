class Solution:
    def countGood(self, nums: List[int], k: int) -> int:
        g = defaultdict(int)
        ans = cur = l = 0
        n = len(nums)
        for r in range(n):
            cur += g[nums[r]]
            g[nums[r]] += 1
            while cur >= k:
                ans += n - r
                cur -= g[nums[l]] - 1
                g[nums[l]] -= 1
                l += 1
        return ans