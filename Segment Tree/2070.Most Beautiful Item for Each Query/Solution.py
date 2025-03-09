class Node:
    def __init__(self, l, r):
        self.left = None
        self.right = None
        self.l = l
        self.r = r
        self.mid = (l + r) >> 1
        self.v = 0

class Segment_Tree:
    def __init__(self):
        self.root = Node(0, int(1e9))

    def query_range(self, l, r, node=None):
        if l > r:
            return 0
        node = node if node else self.root
        if l <= node.l and node.r <= r:
            return node.v
        self.push_down(node)
        ans = 0
        if l <= node.mid:
            ans = max(ans, self.query_range(l, r, node.left))
        if node.mid < r:
            ans = max(ans, self.query_range(l, r, node.right))
        return ans

    def modify_range(self, l, r, v, node=None):
        if l > r:
            return
        node = node if node else self.root
        if l <= node.l and node.r <= r:
            node.v = max(node.v, v)
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


class Solution:
    def maximumBeauty(self, items: List[List[int]], queries: List[int]) -> List[int]:
        st = Segment_Tree()
        for i, v in items:
            st.modify_range(i, i, v)
        return [st.query_range(1, v) for v in queries]