# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def lcaDeepestLeaves(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        def dfs(root, depth):
            if not root:
                return depth
            l = dfs(root.left, depth + 1)
            r = dfs(root.right, depth + 1)
            return max(l, r)


        if not root:
            return root
        l = dfs(root.left, 0)
        r = dfs(root.right, 0)
        if l == r:
            return root
        return self.lcaDeepestLeaves(root.left) if l > r else self.lcaDeepestLeaves(root.right)