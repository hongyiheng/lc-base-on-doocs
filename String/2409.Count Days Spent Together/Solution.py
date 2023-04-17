class Solution:
    def countDaysTogether(self, arriveAlice: str, leaveAlice: str, arriveBob: str, leaveBob: str) -> int:
        def get_day(s):
            months = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
            month, day = int(s.split("-")[0]) - 1, int(s.split("-")[1])
            for i, v in enumerate(months):
                if i >= month:
                    break
                day += v
            return day

        a, b = get_day(arriveAlice), get_day(leaveAlice)
        c, d = get_day(arriveBob), get_day(leaveBob)
        if b < c or d < a:
            return 0
        return min(b, d) - max(a, c) + 1
