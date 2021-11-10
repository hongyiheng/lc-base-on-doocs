class Solution:
    def findPoisonedDuration(self, timeSeries: List[int], duration: int) -> int:
        res = duration
        for i in range(len(timeSeries) - 1):
            res += min(duration, timeSeries[i + 1] - timeSeries[i])
        return res