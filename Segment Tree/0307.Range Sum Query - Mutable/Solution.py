class Node:
    def __init__(self):
        self.l = 0
        self.r = 0
        self.v = 0

class SegmentTree:
    def __init__(self, nums):
        self.nums = nums
        n = len(nums)
        self.tr = [Node() for _ in range(4 * n)]
        self.idx = 0
        self.build(1, 1, n)

    def build(self, u, l, r):
        self.tr[u].l = l
        self.tr[u].r = r
        if l == r:
            self.tr[u].v = self.nums[self.idx]
            self.idx += 1
            return
        mid = (l + r) >> 1
        self.build(u << 1, l, mid)
        self.build(u << 1 | 1, mid + 1, r)
        self.pushup(u)

    def pushup(self, u):
        self.tr[u].v = self.tr[u << 1].v + self.tr[u << 1 | 1].v

    def query(self, u, l, r):
        if self.tr[u].l >= l and self.tr[u].r <= r:
            return self.tr[u].v
        mid = (self.tr[u].l + self.tr[u].r) >> 1
        v = 0
        if l <= mid:
            v += self.query(u << 1, l, r)
        if r > mid:
            v += self.query(u << 1 | 1, l, r)
        return v

    def modify(self, u, x, incr):
        if self.tr[u].l == x and self.tr[u].r == x:
            self.tr[u].v += incr
            return
        mid = (self.tr[u].l + self.tr[u].r) >> 1
        if x <= mid:
            self.modify(u << 1, x, incr)
        else:
            self.modify(u << 1 | 1, x, incr)
        self.pushup(u)

class NumArray:

    def __init__(self, nums: List[int]):
        self.nums = nums
        self.tree = SegmentTree(nums)


    def update(self, index: int, val: int) -> None:
        self.tree.modify(1, index + 1, val - self.tree.query(1, index + 1, index + 1))


    def sumRange(self, left: int, right: int) -> int:
        return self.tree.query(1, left + 1, right + 1)



# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# obj.update(index,val)
# param_2 = obj.sumRange(left,right)