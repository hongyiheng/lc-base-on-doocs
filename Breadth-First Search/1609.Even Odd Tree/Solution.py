# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isEvenOddTree(self, root: Optional[TreeNode]) -> bool:
        stk, cur = [root], True
        while stk:
            childs = stk[:]
            stk = []
            order = float('-inf') if cur else float('inf')
            for node in childs:
                if cur:
                    if node.val % 2 == 0 or order >= node.val:
                        return False
                else:
                    if node.val % 2 != 0 or order <= node.val:
                        return False
                order = node.val
                if node.left:
                    stk.append(node.left)
                if node.right:
                    stk.append(node.right)
            cur = not cur
        return True