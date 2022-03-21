# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findTarget(self, root: Optional[TreeNode], k: int) -> bool:
        s = set()

        def dfs(root):
            nonlocal s, k
            if root is None:
                return False
            if root.val in s:
                return True
            s.add(k - root.val)
            left = dfs(root.left)
            right = dfs(root.right)
            return left or right

        return dfs(root)