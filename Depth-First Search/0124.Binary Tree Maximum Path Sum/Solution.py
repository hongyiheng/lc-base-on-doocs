# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        ans = root.val

        def dfs(root):
            nonlocal ans
            if not root:
                return 0
            left = max(dfs(root.left), 0)
            right = max(dfs(root.right), 0)
            ans = max(ans, root.val + left + right)
            return root.val + max(left, right)

        dfs(root)
        return ans