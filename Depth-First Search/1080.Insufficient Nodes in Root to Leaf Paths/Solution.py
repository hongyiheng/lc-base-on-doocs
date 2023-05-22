# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sufficientSubset(self, root: Optional[TreeNode], limit: int) -> Optional[TreeNode]:
        def dfs(root, s):
            s += root.val
            if not root.left and not root.right:
                return (root if s >= limit else None, s)
            mx = -inf
            if root.left:
                l = dfs(root.left, s)
                mx = max(mx, l[1])
                root.left = l[0]
            if root.right:
                r = dfs(root.right, s)
                mx = max(mx, r[1])
                root.right = r[0]
            return (root if mx >= limit else None, mx)

        return dfs(root, 0)[0]
