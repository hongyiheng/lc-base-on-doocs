class Node:
    def __init__(self, l, r):
        self.l = l
        self.r = r
        self.v = 0
        self.lazy = 0
        self.mid = (l + r) >> 1
        self.left = None
        self.right = None


class SegmentTree:
    def __init__(self):
        self.root = Node(0, int(1e6))

    def query(self, l, r, node=None):
        if not node:
            node = self.root
        if l > r:
            return 0
        if l <= node.l and node.r <= r:
            return node.v
        self.pushDown(node)
        ans = 0
        if l <= node.mid:
            ans += self.query(l, r, node.left)
        if node.mid < r:
            ans += self.query(l, r, node.right)
        return ans

    def modify(self, l, r, node=None):
        if not node:
            node = self.root
        if l > r:
            return
        if l <= node.l and node.r <= r:
            node.lazy ^= 1
            node.v = node.r - node.l + 1 - node.v
            return
        self.pushDown(node)
        if l <= node.mid:
            self.modify(l, r, node.left)
        if node.mid < r:
            self.modify(l, r, node.right)
        self.pushUp(node)

    def pushUp(self, node):
        node.v = node.left.v + node.right.v

    def pushDown(self, node):
        if not node.left:
            node.left = Node(node.l, node.mid)
        if not node.right:
            node.right = Node(node.mid + 1, node.r)
        if node.lazy:
            node.left.v = node.left.r - node.left.l + 1 - node.left.v
            node.left.lazy ^= 1
            node.right.v = node.right.r - node.right.l + 1 - node.right.v
            node.right.lazy ^= 1
        node.lazy = 0

class Solution:
    def handleQuery(self, nums1: List[int], nums2: List[int], queries: List[List[int]]) -> List[int]:
        st = SegmentTree()
        for i, v in enumerate(nums1):
            if v:
                st.modify(i, i)
        s = sum(nums2)
        ans = []
        for q in queries:
            if q[0] == 1:
                st.modify(q[1], q[2])
            elif q[0] == 2:
                s += st.query(0, int(1e9)) * q[1]
            else:
                ans.append(s)
        return ans