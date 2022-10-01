# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def convertBST(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        cur = 0

        def dfs(root):
            nonlocal cur
            if not root:
                return 0
            dfs(root.right)
            cur += root.val
            root.val = cur
            dfs(root.left)

        dfs(root)
        return root
