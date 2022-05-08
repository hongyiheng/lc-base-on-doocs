# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def closestValue(self, root: Optional[TreeNode], target: float) -> int:
        ans = float('inf')

        def dfs(root):
            nonlocal ans, target
            if not root:
                return
            if abs(root.val - target) <= abs(ans - target):
                ans = root.val
            if root.val < target:
                dfs(root.right)
            else:
                dfs(root.left)

        dfs(root)
        return ans