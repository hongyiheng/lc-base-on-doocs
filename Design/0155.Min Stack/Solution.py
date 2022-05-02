class MinStack:
    def __init__(self):
        self.q = []

    def push(self, val: int) -> None:
        if len(self.q) == 0:
            self.q.append([val, val])
        else:
            self.q.append([val, min(val, self.q[-1][1])])

    def pop(self) -> None:
        self.q.pop()

    def top(self) -> int:
        return self.q[-1][0]

    def getMin(self) -> int:
        return self.q[-1][1]



# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()