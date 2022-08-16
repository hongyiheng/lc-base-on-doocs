class OrderedStream:

    def __init__(self, n: int):
        self.q = [None] * (n + 1)
        self.ptr = 1


    def insert(self, idKey: int, value: str) -> List[str]:
        self.q[idKey] = value
        ans = []
        while self.ptr < len(self.q) and self.q[self.ptr]:
            ans.append(self.q[self.ptr])
            self.ptr += 1
        return ans




# Your OrderedStream object will be instantiated and called as such:
# obj = OrderedStream(n)
# param_1 = obj.insert(idKey,value)