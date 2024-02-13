class Solution:
    def countTestedDevices(self, batteryPercentages: List[int]) -> int:
        ans, cur = 0, 1
        for v in batteryPercentages:
            if v >= cur:
                ans += 1
                cur += 1
        return ans

