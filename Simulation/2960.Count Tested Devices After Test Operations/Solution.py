class Solution:
    def countTestedDevices(self, batteryPercentages: List[int]) -> int:
        ans = cnt = 0
        for v in batteryPercentages:
            if v - cnt > 0:
                cnt += 1
                ans += 1
        return ans