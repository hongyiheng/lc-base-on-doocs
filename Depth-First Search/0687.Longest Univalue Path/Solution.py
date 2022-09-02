# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def longestUnivaluePath(self, root: Optional[TreeNode]) -> int:
        ans = 0

        def dfs(root):
            nonlocal ans
            if not root:
                return 0
            left, right = dfs(root.left), dfs(root.right)
            cur = item = 0
            if root.left and root.left.val == root.val:
                cur = item = left + 1
            if root.right and root.right.val == root.val:
                cur += right + 1
                item = max(item, right + 1)
            ans = max(ans, max(item, cur))
            return item

        dfs(root)
        return ans