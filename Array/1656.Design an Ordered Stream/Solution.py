class OrderedStream:

    def __init__(self, n: int):
        self.ws = [None] * n
        self.i = 0

    def insert(self, idKey: int, value: str) -> List[str]:
        self.ws[idKey - 1] = value
        ans = []
        while self.i < len(self.ws) and self.ws[self.i]:
            ans.append(self.ws[self.i])
            self.i += 1
        return ans

# Your OrderedStream object will be instantiated and called as such:
# obj = OrderedStream(n)
# param_1 = obj.insert(idKey,value)