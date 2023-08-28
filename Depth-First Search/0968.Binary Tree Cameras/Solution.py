# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minCameraCover(self, root: Optional[TreeNode]) -> int:
        def dfs(root):
            nonlocal ans
            if not root:
                return -1
            l, r = dfs(root.left), dfs(root.right)
            if l == 0 or r == 0:
                ans += 1
                return 1
            return -1 if l == 1 or r == 1 else 0

        ans = 0
        if dfs(root) == 0:
            ans += 1
        return ans