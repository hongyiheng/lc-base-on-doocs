# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def mergeTrees(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> Optional[TreeNode]:
        def dfs(a, b, cur):
            if not a and not b:
                return
            cur.val = (a.val if a else 0) + (b.val if b else 0)
            if (a and a.left) or (b and b.left):
                cur.left = TreeNode()
                dfs(a.left if a else None, b.left if b else None, cur.left)
            if (a and a.right) or (b and b.right):
                cur.right = TreeNode()
                dfs(a.right if a else None, b.right if b else None, cur.right)

        if not root1 and not root2:
            return None
        ans = TreeNode()
        dfs(root1, root2, ans)
        return ans
