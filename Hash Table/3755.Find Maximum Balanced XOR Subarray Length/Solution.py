class Solution:
    def maxBalancedSubarray(self, nums: List[int]) -> int:
        g = dict()
        g[(0, 0)] = -1
        ans = s = msk = 0
        for i, v in enumerate(nums):
            msk ^= v
            s += 1 if v % 2 else -1
            k = (msk, s)
            if k in g:
                ans = max(ans, i - g[k])
            else:
                g[k] = i
        return ans