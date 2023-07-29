# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxProduct(self, root: Optional[TreeNode]) -> int:
        def dfs(root):
            if not root:
                return 0
            left = dfs(root.left)
            right = dfs(root.right)
            res = root.val + left + right
            root.val = res
            return res

        def dfs1(root):
            nonlocal s, ans
            if not root:
                return
            dfs1(root.left)
            dfs1(root.right)
            ans = max(ans, (s - root.val) * root.val)

        s = dfs(root)
        ans = 0
        dfs1(root)
        return ans % int(1e9 + 7)