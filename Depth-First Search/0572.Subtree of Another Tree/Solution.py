# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSubtree(self, root: TreeNode, subRoot: TreeNode) -> bool:
        if not subRoot:
            return True
        if not root:
            return False

        def dfs(root, sub):
            if root is None and sub is None:
                return True
            if root is None or sub is None:
                return False
            if root.val != sub.val:
                return False
            return dfs(root.left, sub.left) and dfs(root.right, sub.right)

        return self.isSubtree(root.left, subRoot) or self.isSubtree(root.right, subRoot) or dfs(root, subRoot)