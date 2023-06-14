class Solution:
    def numTimesAllBlue(self, flips: List[int]) -> int:
        ans = mx = 0
        for i, v in enumerate(flips):
            mx = max(v, mx)
            if mx == i + 1:
                ans += 1
        return ans
