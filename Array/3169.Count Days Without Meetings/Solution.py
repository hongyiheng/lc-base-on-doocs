class Solution:
    def countDays(self, days: int, meetings: List[List[int]]) -> int:
        meetings.sort(key=lambda x:(x[0], x[1]))
        i = s = 0
        while i < len(meetings):
            l, r = meetings[i]
            while i + 1 < len(meetings) and meetings[i + 1][0] <= r:
                r = max(r, meetings[i + 1][1])
                i += 1
            s += r - l + 1
            i += 1
        return days - s