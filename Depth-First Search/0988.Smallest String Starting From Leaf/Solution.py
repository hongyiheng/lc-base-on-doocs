# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def smallestFromLeaf(self, root: Optional[TreeNode]) -> str:
        def dfs(root, path):
            if not root.left and not root.right:
                q.append("".join(path)[::-1])
                return
            if root.left:
                path.append(chr(root.left.val + ord('a')))
                dfs(root.left, path)
                path.pop()
            if root.right:
                path.append(chr(root.right.val + ord('a')))
                dfs(root.right, path)
                path.pop()

        q = []
        dfs(root, [chr(root.val + ord('a'))])
        q.sort()
        return q[0]
