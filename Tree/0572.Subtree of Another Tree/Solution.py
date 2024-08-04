# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        def dfs(root, subRoot):
            if not root and not subRoot:
                return True
            if root and subRoot:
                if root.val != subRoot.val:
                    return False
                return dfs(root.left, subRoot.left) and dfs(root.right, subRoot.right)
            return False

        if not root:
            return False
        return dfs(root, subRoot) or self.isSubtree(root.left, subRoot) or self.isSubtree(root.right, subRoot)
