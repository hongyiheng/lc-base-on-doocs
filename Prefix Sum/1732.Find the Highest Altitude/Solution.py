class Solution:
    def largestAltitude(self, gain: List[int]) -> int:
        ans = last = 0
        for num in gain:
            last += num
            ans = max(ans, last)
        return ans