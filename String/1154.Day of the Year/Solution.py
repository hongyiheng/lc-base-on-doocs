class Solution:
    def dayOfYear(self, date: str) -> int:
        months = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
        strs = date.split('-')
        year, month, day = int(strs[0]), int(strs[1]), int(strs[2])
        if year % 4 == 0:
            months[2] += 1
        ans = 0
        while month > 0:
            month -= 1
            ans += months[month]
        return ans + day