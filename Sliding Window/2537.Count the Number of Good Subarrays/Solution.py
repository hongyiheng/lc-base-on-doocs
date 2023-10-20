class Solution:
    def countGood(self, nums: List[int], k: int) -> int:
        g = defaultdict(int)
        ans = cur = 0
        l, r, n = 0, 0, len(nums)
        while r < n:
            cur += g[nums[r]]
            g[nums[r]] += 1
            while cur >= k:
                ans += (n - r)
                cur -= (g[nums[l]] - 1)
                g[nums[l]] -= 1
                l += 1
            r += 1
        return ans