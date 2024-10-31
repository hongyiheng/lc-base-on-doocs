class Solution:
    def countDays(self, days: int, meetings: List[List[int]]) -> int:
        meetings.sort(key=lambda x:(x[0], -x[1]))
        ans = mx = 0
        for u, v in meetings:
            if u > mx + 1:
                ans += u - mx - 1
            mx = max(mx, v)
        return ans if mx >= days else ans + days - mx
