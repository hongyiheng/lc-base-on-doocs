class Solution:
    def maximumUnits(self, boxTypes: List[List[int]], truckSize: int) -> int:
        boxTypes.sort(key=lambda x: -x[1])
        ans = 0
        for n, s in boxTypes:
            ans += min(n, truckSize) * s
            truckSize -= n
            if truckSize <= 0:
                break
        return ans
