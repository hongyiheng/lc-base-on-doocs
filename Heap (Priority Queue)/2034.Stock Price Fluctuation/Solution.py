class StockPrice:

    def __init__(self):
        self.g = dict()
        self.max = []
        self.mi = []
        self.cur = -1

    def update(self, timestamp: int, price: int) -> None:
        self.g[timestamp] = price
        heapq.heappush(self.max, (-price, timestamp))
        heapq.heappush(self.mi, (price, timestamp))
        if timestamp > self.cur:
            self.cur = timestamp

    def current(self) -> int:
        return self.g[self.cur]

    def maximum(self) -> int:
        while self.max and -self.g[self.max[0][1]] != self.max[0][0]:
            heapq.heappop(self.max)
        return -self.max[0][0]

    def minimum(self) -> int:
        while self.mi and self.g[self.mi[0][1]] != self.mi[0][0]:
            heapq.heappop(self.mi)
        return self.mi[0][0]


# Your StockPrice object will be instantiated and called as such:
# obj = StockPrice()
# obj.update(timestamp,price)
# param_2 = obj.current()
# param_3 = obj.maximum()
# param_4 = obj.minimum()