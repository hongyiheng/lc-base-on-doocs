# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root:
            return None
        if p.val > q.val:
            return self.lowestCommonAncestor(root, q, p)
        if q.val < root.val:
            return self.lowestCommonAncestor(root.left, q, p)
        if p.val > root.val:
            return self.lowestCommonAncestor(root.right, q, p)
        return root