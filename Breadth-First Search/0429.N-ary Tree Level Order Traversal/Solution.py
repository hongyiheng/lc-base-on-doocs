"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        ans = []
        if root is None:
            return ans
        q = deque()
        q.append(root)
        while q:
            m = len(q)
            row = []
            for _ in range(m):
                cur = q.popleft()
                row.append(cur.val)
                for child in cur.children:
                    q.append(child)
            ans.append(row)
        return ans