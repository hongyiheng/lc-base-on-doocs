# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        def dfs(root, x):
            if not root:
                return 0
            mx = max(root.val, x)
            left = dfs(root.left, mx)
            right = dfs(root.right, mx)
            return left + right + 1 if root.val >= x else left + right

        return dfs(root, root.val)
