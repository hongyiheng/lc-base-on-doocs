class NumArray:
    def lowbit(self, x):
        return x & -x

    def add(self, index, incr):
        i = index
        while i < len(self.tree):
            self.tree[i] += incr
            i += self.lowbit(i)

    def query(self, x):
        ans = 0
        i = x
        while i > 0:
            ans += self.tree[i]
            i -= self.lowbit(i)
        return ans

    def __init__(self, nums: List[int]):
        n = len(nums)
        self.tree = [0] * (n + 1)
        for i, v in enumerate(nums, 1):
            self.add(i, v)

    def update(self, index: int, val: int) -> None:
        prev = self.query(index + 1) - self.query(index)
        self.add(index + 1, val - prev)

    def sumRange(self, left: int, right: int) -> int:
        return self.query(right + 1) - self.query(left)



# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# obj.update(index,val)
# param_2 = obj.sumRange(left,right)