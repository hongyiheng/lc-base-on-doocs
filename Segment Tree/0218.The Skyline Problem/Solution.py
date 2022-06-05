from sortedcontainers import SortedList

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
        self.root = Node(0, 2 ** 31 - 1)

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
            node.v = v
            node.add = v
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
            node.left.add = node.add
            node.right.add = node.add
            node.left.v = node.v
            node.right.v = node.v
            node.add = 0

class Solution:
    def getSkyline(self, buildings: List[List[int]]) -> List[List[int]]:
        buildings.sort(key=lambda x: x[2])
        st = Segment_Tree()
        q = SortedList()
        for item in buildings:
            st.modify(item[0], item[1] - 1, item[2])
            q.add(item[0])
            q.add(item[1])
        ans = []
        last = 0
        for cur in q:
            w = st.query(cur, cur)
            if w != last:
                ans.append([cur, w])
                last = w
        return ans