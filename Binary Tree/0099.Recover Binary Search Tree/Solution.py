# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        pre, first, second = None, None, None
        def dfs(root):
            nonlocal pre, first, second
            if root is None:
                return
            dfs(root.left)
            if first is None and pre and pre.val > root.val:
                first = pre
            if first and pre.val > root.val:
                second = root
            pre = root
            dfs(root.right)

        dfs(root)
        first.val, second.val = second.val, first.val