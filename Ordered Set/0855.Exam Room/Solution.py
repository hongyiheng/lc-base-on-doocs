from sortedcontainers import SortedList

class ExamRoom:

    def __init__(self, n: int):
        self.q = SortedList(key=lambda x: x)
        self.n = n

    def seat(self) -> int:
        if len(self.q) == 0:
            self.q.add(0)
            return 0
        last = self.q[0]
        d, ans = last, 0
        for v in self.q:
            nd = (v - last) // 2
            if d < nd:
                ans = (v + last) // 2
                d = nd
            last = v
        if d < self.n - 1 - last:
            ans = self.n - 1
        self.q.add(ans)
        return ans

    def leave(self, p: int) -> None:
        self.q.remove(p)

# Your ExamRoom object will be instantiated and called as such:
# obj = ExamRoom(n)
# param_1 = obj.seat()
# obj.leave(p)