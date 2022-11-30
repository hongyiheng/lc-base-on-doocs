class FreqStack:

    def __init__(self):
        self.stacks = []
        self.cnt = dict()


    def push(self, val: int) -> None:
        idx = self.cnt.get(val, 0)
        if len(self.stacks) < idx + 1:
            self.stacks.append(list())
        self.stacks[idx].append(val)
        self.cnt[val] = idx + 1

    def pop(self) -> int:
        if len(self.stacks[-1]) == 0:
            self.stacks.pop()
        val = self.stacks[-1].pop()
        self.cnt[val] -= 1
        return val



# Your FreqStack object will be instantiated and called as such:
# obj = FreqStack()
# obj.push(val)
# param_2 = obj.pop()
