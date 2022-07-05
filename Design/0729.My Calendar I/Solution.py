class MyCalendar:

    def __init__(self):
        self.gap = []


    def book(self, start: int, end: int) -> bool:
        for a, b in self.gap:
            if a < end and start < b:
                return False
        self.gap.append([start, end])
        return True




# Your MyCalendar object will be instantiated and called as such:
# obj = MyCalendar()
# param_1 = obj.book(start,end)