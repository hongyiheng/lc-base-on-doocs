class Solution:
    def maxScoreSightseeingPair(self, values: List[int]) -> int:
        mx, ans = -1, 0
        for i, v in enumerate(values):
            if mx != -1:
                ans = max(ans, v + values[mx] + mx - i)
            if mx == -1 or v > values[mx] + mx - i:
                mx = i
        return ans