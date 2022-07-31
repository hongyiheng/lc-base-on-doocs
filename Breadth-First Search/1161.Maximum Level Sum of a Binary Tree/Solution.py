# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxLevelSum(self, root: Optional[TreeNode]) -> int:
        ans, row, mx = 1, 1, root.val
        q = deque()
        q.append(root)
        while q:
            m = len(q)
            tmp = 0
            for _ in range(m):
                cur = q.popleft()
                tmp += cur.val
                if cur.left:
                    q.append(cur.left)
                if cur.right:
                    q.append(cur.right)
            if tmp > mx:
                mx = tmp
                ans = row
            row += 1
        return ans