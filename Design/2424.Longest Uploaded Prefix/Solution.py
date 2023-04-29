class LUPrefix:

    def __init__(self, n: int):
        self.s = set()
        self.x = 0


    def upload(self, video: int) -> None:
        self.s.add(video)


    def longest(self) -> int:
        while self.x + 1 in self.s:
            self.x += 1
        return self.x


# Your LUPrefix object will be instantiated and called as such:
# obj = LUPrefix(n)
# obj.upload(video)
# param_2 = obj.longest()