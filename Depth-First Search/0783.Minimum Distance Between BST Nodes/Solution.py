# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minDiffInBST(self, root: Optional[TreeNode]) -> int:
        def dfs(root):
            nonlocal ans, last
            if not root:
                return
            dfs(root.left)
            ans = min(ans, root.val - last)
            last = root.val
            dfs(root.right)

        ans, last = inf, -inf
        dfs(root)
        return ans
