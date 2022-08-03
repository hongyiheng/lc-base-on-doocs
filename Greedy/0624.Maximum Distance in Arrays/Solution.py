class Solution:
    def maxDistance(self, arrays: List[List[int]]) -> int:
        min_, max_ = float('inf'), float('-inf')
        ans = 0
        for i, r in enumerate(arrays):
            if i > 0:
                ans = max(ans, abs(r[0] - max_))
                ans = max(ans, abs(r[-1] - min_))
            min_ = min(min_, r[0])
            max_ = max(max_, r[-1])
        return ans