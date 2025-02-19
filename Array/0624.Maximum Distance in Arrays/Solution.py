class Solution:
    def maxDistance(self, arrays: List[List[int]]) -> int:
        mi, mx = arrays[0][0], arrays[0][-1]
        ans = 0
        for i in range(1, len(arrays)):
            ans = max(ans, abs(mx - arrays[i][0]))
            ans = max(ans, abs(arrays[i][-1] - mi))
            mx = max(mx, arrays[i][-1])
            mi = min(mi, arrays[i][0])
        return ans