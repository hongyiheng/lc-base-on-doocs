"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

class Solution:
    def maxDepth(self, root: 'Node') -> int:
        ans = 0

        def dfs(root, depth):
            nonlocal ans
            if not root:
                return
            ans = max(ans, depth)
            for item in root.children:
                dfs(item, depth + 1)

        dfs(root, 1)
        return ans