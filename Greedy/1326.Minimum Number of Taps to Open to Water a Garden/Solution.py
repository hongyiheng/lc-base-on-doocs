class Solution:
    def minTaps(self, n: int, ranges: List[int]) -> int:
        M = n + 10
        rs = [0] * M
        for i, v in enumerate(ranges):
            l, r = max(0, i - v), i + v
            rs[l] = max(rs[l], r)
        ans = l = r = 0
        while l < M and r < n:
            if r < l:
                return -1
            mx = r
            for i in range(l, min(r + 1, M)):
                mx = max(mx, rs[i])
            l, r = r + 1, mx
            ans += 1
        return ans if r >= n else -1
