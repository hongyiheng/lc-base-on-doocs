# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def evaluateTree(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True
        l, r = self.evaluateTree(root.left), self.evaluateTree(root.right)
        if root.val == 2:
            return l or r
        elif root.val == 3:
            return l and r
        return True if root.val == 1 else False
