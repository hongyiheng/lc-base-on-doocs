"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        ans = []
        if root is None:
            return ans

        def dfs(root):
            nonlocal ans
            if root is None:
                return ans
            for child in root.children:
                dfs(child)
                ans.append(child.val)

        dfs(root)
        ans.append(root.val)
        return ans