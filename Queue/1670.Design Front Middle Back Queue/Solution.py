class FrontMiddleBackQueue:

    def __init__(self):
        self.front = deque()
        self.tail = deque()

    def balance(self):
        while len(self.front) < len(self.tail):
            self.front.append(self.tail.popleft())
        while len(self.tail) < len(self.front):
            self.tail.appendleft(self.front.pop())

    def pushFront(self, val: int) -> None:
        self.front.appendleft(val)

    def pushMiddle(self, val: int) -> None:
        self.balance()
        self.front.append(val)

    def pushBack(self, val: int) -> None:
        self.tail.append(val)

    def popFront(self) -> int:
        if not self.front and not self.tail:
            return -1
        self.balance()
        return self.front.popleft() if self.front else self.tail.popleft()

    def popMiddle(self) -> int:
        if not self.front and not self.tail:
            return -1
        self.balance()
        return self.front.pop() if len(self.front) == len(self.tail) else self.tail.popleft()

    def popBack(self) -> int:
        if not self.front and not self.tail:
            return -1
        self.balance()
        return self.tail.pop()

# Your FrontMiddleBackQueue object will be instantiated and called as such:
# obj = FrontMiddleBackQueue()
# obj.pushFront(val)
# obj.pushMiddle(val)
# obj.pushBack(val)
# param_4 = obj.popFront()
# param_5 = obj.popMiddle()
# param_6 = obj.popBack()