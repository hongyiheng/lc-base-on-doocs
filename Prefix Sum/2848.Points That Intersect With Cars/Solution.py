class Solution:
    def numberOfPoints(self, nums: List[List[int]]) -> int:
        q = [0] * 110
        for u, v in nums:
            q[u] += 1
            q[v + 1] -= 1
        ans = s = 0
        for v in q:
            s += v
            if s:
                ans += 1
        return ans