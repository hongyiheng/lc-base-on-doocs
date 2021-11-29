class Solution:

    def __init__(self, m: int, n: int):
        self.m = m
        self.n = n
        self.mp = set()

    def flip(self) -> List[int]:
        i = random.randint(0, self.m * self.n - 1)
        while i in self.mp:
            i = random.randint(0, self.m * self.n - 1)
        self.mp.add(i)
        return [int(i / self.n), int(i % self.n)]

    def reset(self) -> None:
        self.mp.clear()



# Your Solution object will be instantiated and called as such:
# obj = Solution(m, n)
# param_1 = obj.flip()
# obj.reset()