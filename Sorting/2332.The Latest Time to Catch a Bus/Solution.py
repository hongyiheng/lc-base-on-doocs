class Solution:
    def latestTimeCatchTheBus(self, buses: List[int], passengers: List[int], capacity: int) -> int:
        buses.sort()
        passengers.sort()
        j = c = 0
        for t in buses:
            c = capacity
            while j < len(passengers) and passengers[j] <= t and c:
                c -= 1
                j += 1
        j -= 1
        ans = buses[-1] if c else passengers[j]
        while j >= 0 and passengers[j] == ans:
            ans -= 1
            j -= 1
        return ans


