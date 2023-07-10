class DataStream:

    def __init__(self, value: int, k: int):
        self.v = value
        self.cnt = 0
        self.k = k


    def consec(self, num: int) -> bool:
        if num == self.v:
            self.cnt += 1
        else:
            self.cnt = 0
        return self.cnt >= self.k



# Your DataStream object will be instantiated and called as such:
# obj = DataStream(value, k)
# param_1 = obj.consec(num)