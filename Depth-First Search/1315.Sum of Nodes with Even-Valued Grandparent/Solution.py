# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumEvenGrandparent(self, root: TreeNode) -> int:
        even = []

        def dfs(root):
            if not root:
                return
            if root.val % 2 == 0:
                even.append(root)
            dfs(root.left)
            dfs(root.right)

        dfs(root)
        ans = 0
        for t in even:
            if t.left and t.left.left:
                ans += t.left.left.val
            if t.left and t.left.right:
                ans += t.left.right.val
            if t.right and t.right.left:
                ans += t.right.left.val
            if t.right and t.right.right:
                ans += t.right.right.val
        return ans
