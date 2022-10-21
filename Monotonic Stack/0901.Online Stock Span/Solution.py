class StockSpanner:

    def __init__(self):
        self.q = []
        self.idx = 0

    def next(self, price: int) -> int:
        while self.q and self.q[-1][1] <= price:
            self.q.pop()
        l = -1 if not self.q else self.q[-1][0]
        ans = self.idx - l
        self.q.append([self.idx, price])
        self.idx += 1
        return ans



# Your StockSpanner object will be instantiated and called as such:
# obj = StockSpanner()
# param_1 = obj.next(price)
