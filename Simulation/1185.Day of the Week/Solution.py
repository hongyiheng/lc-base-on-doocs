class Solution:
    def dayOfTheWeek(self, day: int, month: int, year: int) -> str:
        day_of_week = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"]
        months = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
        if (year % 4 == 0 and year % 100 != 0) or year % 400 == 0:
            months[1] += 1
        for i in range(1971, year):
            day += 366 if (i % 4 == 0 and i % 100 != 0) or i % 400 == 0 else 365
        for i in range(1, month):
            day += months[i - 1]
        return day_of_week[(day + 4) % 7]