# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def averageOfSubtree(self, root: Optional[TreeNode]) -> int:
        ans = 0

        def dfs(root):
            nonlocal ans
            if not root:
                return [0, 0]
            left = dfs(root.left)
            right = dfs(root.right)
            cnt = left[0] + right[0] + 1
            val = left[1] + right[1] + root.val
            if val // cnt == root.val:
                ans += 1
            return [cnt, val]

        dfs(root)
        return ans