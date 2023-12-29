class Solution:
    def maxSubarrayLength(self, nums: List[int], k: int) -> int:
        g = defaultdict(int)
        l = r = ans = 0
        while r < len(nums):
            g[nums[r]] += 1
            while g[nums[r]] > k:
                g[nums[l]] -= 1
                l += 1
            ans = max(ans, r - l + 1)
            r += 1
        return ans