# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isUnivalTree(self, root: TreeNode) -> bool:
        val = root.val
        pre = TreeNode()
        while root:
            if not root.left:
                if root.val != val:
                    return False
                root = root.right
            else:
                pre = root.left
                while pre.right and pre.right != root:
                    pre = pre.right
                if not pre.right:
                    if root.val != val:
                        return False
                    pre.right = root
                    root = root.left
                else:
                    root = root.right
                    pre.right = None
        return True