# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def subtreeWithAllDeepest(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        def dfs(node, d):
            nonlocal ans, md
            if not node:
                return d - 1
            l = dfs(node.left, d + 1)
            r = dfs(node.right, d + 1)
            if l == r and r >= md:
                md = r
                ans = node
            return max(l, r)

        ans = None
        md = 0
        dfs(root, 0)
        return ans
