# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumRootToLeaf(self, root: Optional[TreeNode]) -> int:
        ans = 0

        def dfs(root, cur):
            nonlocal ans
            if not root:
                return
            cur = cur << 1 | root.val
            if not root.left and not root.right:
                ans += cur
                return
            dfs(root.left, cur)
            dfs(root.right, cur)

        dfs(root, 0)
        return ans