class MyCalendarTwo:

    def __init__(self):
        self.task = []
        self.dup = []

    def book(self, start: int, end: int) -> bool:
        for t in self.dup:
            if t[0] < end and t[1] > start:
                return False
        for t in self.task:
            if t[0] < end and t[1] > start:
                self.dup.append([max(start, t[0]), min(end, t[1])])
        self.task.append([start, end])
        return True



# Your MyCalendarTwo object will be instantiated and called as such:
# obj = MyCalendarTwo()
# param_1 = obj.book(start,end)