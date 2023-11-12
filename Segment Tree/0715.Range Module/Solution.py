class Node:
    def __init__(self, l, r):
        self.l = l
        self.r = r
        self.v = False
        self.lazy = 0
        self.mid = (l + r) >> 1
        self.left = None
        self.right = None


class SegmentTree:
    def __init__(self):
        self.root = Node(1, int(1e9))

    def modify(self, l, r, v, node=None):
        if not node:
            node = self.root
        if l <= node.l and node.r <= r:
            node.lazy = v
            node.v = v == 1
            return
        self.pushDown(node)
        if l <= node.mid:
            self.modify(l, r, v, node.left)
        if node.mid < r:
            self.modify(l, r, v, node.right)
        self.pushUp(node)

    def query(self, l, r, node=None):
        if not node:
            node = self.root
        if l <= node.l and node.r <= r:
            return node.v
        self.pushDown(node)
        ans = True
        if l <= node.mid:
            ans = ans and self.query(l, r, node.left)
        if node.mid < r:
            ans = ans and self.query(l, r, node.right)
        return ans


    def pushUp(self, node):
        node.v = node.left.v and node.right.v

    def pushDown(self, node):
        if not node.left:
            node.left = Node(node.l, node.mid)
        if not node.right:
            node.right = Node(node.mid + 1, node.r)
        if node.lazy:
            node.left.v = node.lazy == 1
            node.left.lazy = node.lazy
            node.right.v = node.lazy == 1
            node.right.lazy = node.lazy
        node.lazy = 0

class RangeModule:

    def __init__(self):
        self.st = SegmentTree()

    def addRange(self, left: int, right: int) -> None:
        self.st.modify(left, right - 1, 1)

    def queryRange(self, left: int, right: int) -> bool:
        return self.st.query(left, right - 1)

    def removeRange(self, left: int, right: int) -> None:
        self.st.modify(left, right - 1, -1)


# Your RangeModule object will be instantiated and called as such:
# obj = RangeModule()
# obj.addRange(left,right)
# param_2 = obj.queryRange(left,right)
# obj.removeRange(left,right)