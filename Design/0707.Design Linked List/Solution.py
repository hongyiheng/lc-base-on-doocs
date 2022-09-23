class MyLinkedList:

    def __init__(self):
        self.q = deque()

    def get(self, index: int) -> int:
        if index >= len(self.q):
            return -1
        nums = []
        while len(nums) < index:
            nums.append(self.q.popleft())
        ans = self.q[0]
        while nums:
            self.q.appendleft(nums.pop())
        return ans

    def addAtHead(self, val: int) -> None:
        self.q.appendleft(val)

    def addAtTail(self, val: int) -> None:
        self.q.append(val)


    def addAtIndex(self, index: int, val: int) -> None:
        if index <= 0:
            self.q.appendleft(val)
            return
        if index > len(self.q):
            return
        nums = []
        while len(nums) < index:
            nums.append(self.q.popleft())
        self.q.appendleft(val)
        while nums:
            self.q.appendleft(nums.pop())

    def deleteAtIndex(self, index: int) -> None:
        if index < 0 or index >= len(self.q):
            return
        nums = []
        while len(nums) < index:
            nums.append(self.q.popleft())
        self.q.popleft()
        while nums:
            self.q.appendleft(nums.pop())

# Your MyLinkedList object will be instantiated and called as such:
# obj = MyLinkedList()
# param_1 = obj.get(index)
# obj.addAtHead(val)
# obj.addAtTail(val)
# obj.addAtIndex(index,val)
# obj.deleteAtIndex(index)
