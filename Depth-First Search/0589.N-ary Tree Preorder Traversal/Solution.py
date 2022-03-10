"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        ans = []
        if root is None:
            return ans

        def dfs(root):
            nonlocal ans
            if root is None:
                return
            for child in root.children:
                ans.append(child.val)
                dfs(child)

        ans.append(root.val)
        dfs(root)
        return ans