class Node:
    def __init__(self, l, r):
        self.l = l
        self.r = r
        self.mid = (l + r) >> 1
        self.v = 0
        self.left = None
        self.right = None
        self.lazy = False


class Segment_Tree:
    def __init__(self, l, r):
        self.root = Node(l, r)

    def modify(self, l, r, node=None):
        if not node:
            node = self.root
        if l <= node.l and node.r <= r:
            node.v = node.r - node.l + 1
            node.lazy = True
            return
        self.pushDown(node)
        if l <= node.mid:
            self.modify(l, r, node.left)
        if node.mid < r:
            self.modify(l, r, node.right)
        self.pushUp(node)

    def query(self, l, r, node=None):
        if not node:
            node = self.root
        if l <= node.l and node.r <= r:
            return node.v
        self.pushDown(node)
        ans = 0
        if l <= node.mid:
            ans += self.query(l, r, node.left)
        if node.mid < r:
            ans += self.query(l, r, node.right)
        return ans

    def pushUp(self, node):
        node.v = node.left.v + node.right.v

    def pushDown(self, node):
        if not node.left:
            node.left = Node(node.l, node.mid)
        if not node.right:
            node.right = Node(node.mid + 1, node.r)
        if node.lazy:
            node.left.v = node.left.r - node.left.l + 1
            node.left.lazy = True
            node.right.v = node.right.r - node.right.l + 1
            node.right.lazy = True
        node.lazy = False

class CountIntervals:

    def __init__(self):
        self.st = Segment_Tree(1, int(1e9))

    def add(self, left: int, right: int) -> None:
        self.st.modify(left, right)

    def count(self) -> int:
        return self.st.query(1, int(1e9))



# Your CountIntervals object will be instantiated and called as such:
# obj = CountIntervals()
# obj.add(left,right)
# param_2 = obj.count()