# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        ans = 0
        if not root:
            return ans

        def dfs(root):
            nonlocal ans
            if not root.left and not root.right:
                return 0
            left = dfs(root.left) + 1 if root.left else 0
            right = dfs(root.right) + 1 if root.right else 0
            ans = max(ans, left + right)
            return max(left, right)

        dfs(root)
        return ans
