class Solution:
    def maxFreeTime(self, eventTime: int, k: int, startTime: List[int], endTime: List[int]) -> int:
        free = [startTime[0]]
        for i in range(1, len(startTime)):
            free.append(startTime[i] - endTime[i - 1])
        free.append(eventTime - endTime[-1])
        ans = s = 0
        for i, v in enumerate(free):
            s += v
            if i < k:
                continue
            ans = max(ans, s)
            s -= free[i - k]
        return ans
