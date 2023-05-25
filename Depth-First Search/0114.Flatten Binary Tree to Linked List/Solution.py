# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def flatten(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        def dfs(root):
            if not root:
                return
            q.append(root.val)
            dfs(root.left)
            dfs(root.right)

        q = []
        dfs(root)
        tmp = root
        for i, v in enumerate(q):
            tmp.val = v
            tmp.left = None
            if not tmp.right and i < len(q) - 1:
                tmp.right = TreeNode()
            tmp = tmp.right