# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findTarget(self, root: TreeNode, k: int) -> bool:
        def dfs(root):
            if not root:
                return False
            ans = dfs(root.left)
            if k - root.val in g:
                return True
            g[root.val] = True
            return ans or dfs(root.right)

        g = dict()
        return dfs(root)
