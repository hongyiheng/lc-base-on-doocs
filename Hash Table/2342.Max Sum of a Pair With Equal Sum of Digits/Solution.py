class Solution:
    def maximumSum(self, nums: List[int]) -> int:
        g = dict()
        ans = -1
        for v in nums:
            k = 0
            t = v
            while t:
                k += t % 10
                t //= 10
            nv = g.get(k, 0)
            if nv:
                ans = max(ans, g[k] + v)
            g[k] = max(nv, v)
        return ans