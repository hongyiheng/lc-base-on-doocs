# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def getMinimumDifference(self, root: TreeNode) -> int:
        ans, pre = float('inf'), -1

        def dfs(root):
            nonlocal pre, ans
            if root is None:
                return
            dfs(root.left)
            if pre != -1:
                ans = min(ans, root.val - pre)
            pre = root.val
            dfs(root.right)

        dfs(root)
        return ans