class Solution:
    def getLargestOutlier(self, nums: List[int]) -> int:
        ns = [0] * 2010
        s = 0
        for v in nums:
            ns[v + 1000] += 1
            s += v
        ans = -1010
        for v in nums:
            if (s - v) % 2 != 0:
                continue
            t = (s - v) // 2
            if t < -1000 or t > 1000:
                continue
            if ns[t + 1000] >= 2 or (ns[t + 1000] >= 1 and t != v):
                ans = max(ans, v)
        return ans