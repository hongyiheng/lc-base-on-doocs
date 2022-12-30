from sortedcontainers import SortedList

class ExamRoom:

    def __init__(self, n: int):
        self.q = SortedList(key=lambda x: x)
        self.n = n


    def seat(self) -> int:
        if len(self.q) == 0:
            self.q.add(0)
            return 0
        elif len(self.q) == 1:
            x = self.q[0]
            ans = 0 if x - 0 > self.n - 1 - x else self.n - 1
            self.q.add(ans)
            return ans
        pre = self.q[0]
        d, ans = pre, 0
        for x in self.q:
            if d < (x - pre) // 2:
                d = (x - pre) // 2
                ans = (x + pre) // 2
            pre = x
        if d < self.n - 1 - pre:
            ans = self.n - 1
        self.q.add(ans)
        return ans


    def leave(self, p: int) -> None:
        self.q.remove(p)



# Your ExamRoom object will be instantiated and called as such:
# obj = ExamRoom(n)
# param_1 = obj.seat()
# obj.leave(p)