class DinnerPlates:

    def __init__(self, capacity: int):
        self.cap = capacity
        self.q = []
        self.add_ids = []

    def push(self, val: int) -> None:
        index = len(self.q)
        if self.add_ids:
            index = heapq.heappop(self.add_ids)
        if index < len(self.q):
            self.q[index].append(val)
        else:
            self.q.append([val])
        if len(self.q[index]) < self.cap:
            heapq.heappush(self.add_ids, index)

    def pop(self) -> int:
        return self.popAtStack(len(self.q) - 1)

    def popAtStack(self, index: int) -> int:
        if index < 0 or index >= len(self.q) or not self.q[index]:
            return -1
        if len(self.q[index]) == self.cap:
            heapq.heappush(self.add_ids, index)
        ans = self.q[index].pop()
        while self.q and not self.q[-1]:
            self.add_ids.remove(len(self.q) - 1)
            self.q.pop()
        return ans

# Your DinnerPlates object will be instantiated and called as such:
# obj = DinnerPlates(capacity)
# obj.push(val)
# param_2 = obj.pop()
# param_3 = obj.popAtStack(index)
