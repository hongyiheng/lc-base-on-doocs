class Solution:
    def findRadius(self, houses: List[int], heaters: List[int]) -> int:
        houses.sort()
        heaters.sort()
        ans, heater_index, n = 0, 0, len(heaters)
        for house in houses:
            while heater_index < n - 1 and abs(heaters[heater_index + 1] - house) <= abs(heaters[heater_index] - house):
                heater_index += 1
            if abs(heaters[heater_index] - house) > ans:
                ans = abs(heaters[heater_index] - house)
        return ans