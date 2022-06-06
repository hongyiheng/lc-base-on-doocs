class Node:
    def __init__(self, l, r):
        self.left = None
        self.right = None
        self.l = l
        self.r = r
        self.mid = (l + r) >> 1
        self.v = 0
        self.add = 0

class Segment_Tree:
    def __init__(self):
        self.root = Node(0, int(1e9))

    def query(self, l, r):
        return self.query_range(l, r, self.root)

    def query_range(self, l, r, node):
        if l > r:
            return 0
        if l <= node.l and node.r <= r:
            return node.v
        self.push_down(node)
        ans = 0
        if l <= node.mid:
            ans = max(ans, self.query_range(l, r, node.left))
        if node.mid < r:
            ans = max(ans, self.query_range(l, r, node.right))
        return ans

    def modify(self, l, r, v):
        self.modify_range(l, r, v, self.root)

    def modify_range(self, l, r, v, node):
        if l > r:
            return
        if l <= node.l and node.r <= r:
            node.v += v
            node.add += v
            return
        self.push_down(node)
        if l <= node.mid:
            self.modify_range(l, r, v, node.left)
        if node.mid < r:
            self.modify_range(l, r, v, node.right)
        self.push_up(node)

    def push_up(self, node):
        node.v = max(node.left.v, node.right.v)

    def push_down(self, node):
        if not node.left:
            node.left = Node(node.l, node.mid)
        if not node.right:
            node.right = Node(node.mid + 1, node.r)
        if node.add:
            node.left.add += node.add
            node.right.add += node.add
            node.left.v += node.add
            node.right.v += node.add
            node.add = 0

class MyCalendarThree:

    def __init__(self):
        self.st = Segment_Tree()

    def book(self, start: int, end: int) -> int:
        self.st.modify(start, end - 1, 1)
        return self.st.query(0, int(1e9))



# Your MyCalendarThree object will be instantiated and called as such:
# obj = MyCalendarThree()
# param_1 = obj.book(start,end)