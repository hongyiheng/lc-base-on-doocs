# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:
        ans = 0

        def dfs(root, t):
            nonlocal ans
            if not root:
                return
            if root.val == t:
                ans += 1
            dfs(root.left, t - root.val)
            dfs(root.right, t - root.val)

        q = [root]
        while q:
            cur = q.pop()
            if not cur:
                continue
            dfs(cur, targetSum)
            q.append(cur.left)
            q.append(cur.right)
        return ans