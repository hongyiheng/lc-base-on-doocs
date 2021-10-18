# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        p1, p2, d1, d2 = None, None, None, None

        def dfs(root, parent, depth):
            nonlocal p1, p2, d1, d2
            if root is None:
                return
            if root.val == x:
                p1 = parent
                d1 = depth
            if root.val == y:
                p2 = parent
                d2 = depth
            dfs(root.left, root, depth + 1)
            dfs(root.right, root, depth + 1)

        dfs(root, None, 0)
        return p1 != p2 and d1 == d2