class Solution:
    def countCompleteSubarrays(self, nums: List[int]) -> int:
        n = len(nums)
        l = r = ans = 0
        t = len(set(nums))
        g = dict()
        while r < n:
            g[nums[r]] = g.get(nums[r], 0) + 1
            while len(g.keys()) == t:
                ans += n - r
                v = g[nums[l]]
                if v == 1:
                    g.pop(nums[l])
                else:
                    g[nums[l]] = v - 1
                l += 1
            r += 1
        return ans
