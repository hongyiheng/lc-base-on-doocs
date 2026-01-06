# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxLevelSum(self, root: Optional[TreeNode]) -> int:
        ans, mx, d = 1, root.val, 0
        q = deque([root])
        while q:
            row = 0
            for _ in range(len(q)):
                v = q.popleft()
                row += v.val
                if v.left:
                    q.append(v.left)
                if v.right:
                    q.append(v.right)
            d += 1
            if mx < row:
                mx = row
                ans = d
        return ans