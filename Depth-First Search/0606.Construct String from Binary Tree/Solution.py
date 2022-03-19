# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def tree2str(self, root: Optional[TreeNode]) -> str:
        ans = ""

        def dfs(root):
            nonlocal ans
            if root is None:
                return
            ans += str(root.val)
            if root.left is None and root.right is None:
                return
            ans += "("
            dfs(root.left)
            ans += ")"
            if root.right:
                ans += "("
                dfs(root.right)
                ans += ")"

        dfs(root)
        return ans