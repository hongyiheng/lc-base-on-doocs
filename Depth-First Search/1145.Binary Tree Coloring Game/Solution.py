# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def btreeGameWinningMove(self, root: Optional[TreeNode], n: int, x: int) -> bool:
        l = r = 0

        def dfs(root):
            nonlocal l, r
            if not root:
                return 0
            left = dfs(root.left)
            right = dfs(root.right)
            if root.val == x:
                l = left
                r = right
            return left + right + 1

        dfs(root)
        return l > n / 2 or r > n / 2 or (l + r + 1) < n / 2