class Solution:
    def largestAltitude(self, gain: List[int]) -> int:
        ans = cur = 0
        for v in gain:
            cur += v
            ans = max(ans, cur)
        return ans
