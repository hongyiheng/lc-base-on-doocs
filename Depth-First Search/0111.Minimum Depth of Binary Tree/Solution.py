# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minDepth(self, root: TreeNode) -> int:
        def dfs(depth, root):
            nonlocal ans
            if root is None:
                return
            if root.left is None and root.right is None:
                if depth < ans:
                    ans = depth
            dfs(depth + 1, root.left)
            dfs(depth + 1, root.right)

        if root is None:
            return 0
        ans = float('inf')
        dfs(1, root)
        return ans