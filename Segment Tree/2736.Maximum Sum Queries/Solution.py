class Node:
    def __init__(self, l, r):
        self.left = None
        self.right = None
        self.l = l
        self.r = r
        self.mid = (l + r) >> 1
        self.v = -1


class Segment_Tree:
    def __init__(self):
        self.root = Node(1, int(1e9))

    def query_range(self, l, r, node=None):
        if not node:
            node = self.root
        if l <= node.l and node.r <= r:
            return node.v
        self.push_down(node)
        ans = -1
        if l <= node.mid:
            ans = max(ans, self.query_range(l, r, node.left))
        if node.mid < r:
            ans = max(ans, self.query_range(l, r, node.right))
        return ans

    def modify_range(self, l, r, v, node=None):
        if not node:
            node = self.root
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
    def maximumSumQueries(self, nums1: List[int], nums2: List[int], queries: List[List[int]]) -> List[int]:
        nums = [(a, b) for a, b in zip(nums1, nums2)]
        nums.sort(key=lambda x: -x[0])
        q = [(v[0], v[1], i) for i, v in enumerate(queries)]
        q.sort(key=lambda x: -x[0])

        st = Segment_Tree()
        n, m = len(nums1), len(queries)
        ans = [-1] * m
        j = 0
        for x, y, i in q:
            while j < n and nums[j][0] >= x:
                st.modify_range(nums[j][1], nums[j][1], nums[j][0] + nums[j][1])
                j += 1
            ans[i] = st.query_range(y, inf)
        return ans