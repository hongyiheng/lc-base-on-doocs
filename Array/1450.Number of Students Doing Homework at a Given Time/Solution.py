class Solution:
    def busyStudent(self, startTime: List[int], endTime: List[int], queryTime: int) -> int:
        t = [0] * 1010
        for v in startTime:
            t[v] += 1
        for v in endTime:
            t[v + 1] -= 1
        return sum(t[:queryTime + 1])