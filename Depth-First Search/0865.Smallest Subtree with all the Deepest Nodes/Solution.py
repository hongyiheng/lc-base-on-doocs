# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def subtreeWithAllDeepest(self, root: TreeNode) -> TreeNode:
        def dfs(root):
            if not root:
                return 0
            l, r = dfs(root.left), dfs(root.right)
            return max(l, r) + 1

        l, r = dfs(root.left), dfs(root.right)
        if l == r:
            return root
        return self.subtreeWithAllDeepest(root.left) if l > r else self.subtreeWithAllDeepest(root.right)

