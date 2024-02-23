# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthLargestLevelSum(self, root: Optional[TreeNode], k: int) -> int:
        q = deque([root])
        rs = []
        while q:
            s = 0
            for _ in range(len(q)):
                cur = q.popleft()
                s += cur.val
                if cur.left:
                    q.append(cur.left)
                if cur.right:
                    q.append(cur.right)
            rs.append(s)
        if len(rs) < k:
            return -1
        rs.sort(reverse=True)
        return rs[k - 1]