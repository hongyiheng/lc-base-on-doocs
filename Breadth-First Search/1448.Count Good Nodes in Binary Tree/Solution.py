# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        ans = 0
        q = [[root, root.val]]
        while q:
            t, x = q.pop()
            ans += t.val >= x
            nx = max(x, t.val)
            if t.left:
                q.append([t.left, nx])
            if t.right:
                q.append([t.right, nx])
        return ans
