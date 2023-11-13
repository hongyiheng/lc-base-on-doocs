class Node:
    def __init__(self, l, r):
        self.l = l
        self.r = r
        self.mid = (l + r) >> 1
        self.left = None
        self.right = None
        self.v = 0


class SegmentTree():

    def __init__(self, l, r):
        self.root = Node(l, r)

    def modify(self, l, r, v, node=None):
        if not node:
            node = self.root
        if l <= node.l and node.r <= r:
            node.v = v
            return
        self.pushDown(node)
        if l <= node.mid:
            self.modify(l, r, v, node.left)
        if r > node.mid:
            self.modify(l, r, v, node.right)
        self.pushUp(node)

    def pushDown(self, node):
        if not node.left:
            node.left = Node(node.l, node.mid)
        if not node.right:
            node.right = Node(node.mid + 1, node.r)

    def pushUp(self, node):
        node.v = node.left.v + node.right.v

    def query(self, l, r, node=None):
        if not node:
            node = self.root
        if l <= node.l and node.r <= r:
            return node.v
        self.pushDown(node)
        ans = 0
        if l <= node.mid:
            ans += self.query(l, r, node.left)
        if r > node.mid:
            ans += self.query(l, r, node.right)
        return ans


class NumArray:

    def __init__(self, nums: List[int]):
        self.st = SegmentTree(0, 30010)
        for i, v in enumerate(nums):
            self.st.modify(i, i, v)

    def update(self, index: int, val: int) -> None:
        self.st.modify(index, index, val)

    def sumRange(self, left: int, right: int) -> int:
        return self.st.query(left, right)

# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# obj.update(index,val)
# param_2 = obj.sumRange(left,right)