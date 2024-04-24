# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def amountOfTime(self, root: Optional[TreeNode], start: int) -> int:
        def dfs(root):
            nonlocal ans
            if not root:
                return (False, 0)
            l, r = dfs(root.left), dfs(root.right)

            if root.val == start:
                ans = max(ans, l[1], r[1])
                return (True, 0)
            elif l[0] or r[0]:
                ans = max(ans, l[1] + r[1] + 1)
                return (True, l[1] + 1 if l[0] else r[1] + 1)
            return (False, max(l[1], r[1]) + 1)

        ans = 0
        dfs(root)
        return ans