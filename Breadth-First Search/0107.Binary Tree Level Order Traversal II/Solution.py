# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrderBottom(self, root: Optional[TreeNode]) -> List[List[int]]:
        ans = list()
        if not root:
            return ans
        q = deque()
        q.append(root)
        while q:
            row = []
            for _ in range(len(q)):
                cur = q.popleft()
                row.append(cur.val)
                if cur.left:
                    q.append(cur.left)
                if cur.right:
                    q.append(cur.right)
            ans.append(row)
        return ans[::-1]