# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def longestZigZag(self, root: Optional[TreeNode]) -> int:
        def dfs(root, cnt, left):
            if not root:
                return 0
            if left:
                l, r = dfs(root.left, 1, True), dfs(root.right, cnt + 1, False)
            else:
                l, r = dfs(root.left, cnt + 1, True), dfs(root.right, 1, False)
            return max(l, r, cnt)

        return dfs(root, 0, True)