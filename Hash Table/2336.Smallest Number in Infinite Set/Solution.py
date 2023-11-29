from sortedcontainers import SortedSet

class SmallestInfiniteSet:

    def __init__(self):
        self.q = SortedSet(range(1, 1001))

    def popSmallest(self) -> int:
        ans = self.q[0]
        self.q.remove(ans)
        return ans

    def addBack(self, num: int) -> None:
        self.q.add(num)



# Your SmallestInfiniteSet object will be instantiated and called as such:
# obj = SmallestInfiniteSet()
# param_1 = obj.popSmallest()
# obj.addBack(num)