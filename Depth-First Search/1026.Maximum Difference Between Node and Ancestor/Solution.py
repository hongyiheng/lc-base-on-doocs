# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxAncestorDiff(self, root: Optional[TreeNode]) -> int:
        ans = 0

        def dfs(mx, mi, root):
            nonlocal ans
            if not root:
                return
            ans = max(ans, abs(mx - root.val))
            ans = max(ans, abs(mi - root.val))
            mx = max(mx, root.val)
            mi = min(mi, root.val)
            dfs(mx, mi, root.left)
            dfs(mx, mi, root.right)

        dfs(root.val, root.val, root)
        return ans