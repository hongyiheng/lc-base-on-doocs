# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCompleteTree(self, root: Optional[TreeNode]) -> bool:
        q = deque([root])
        last = 0
        while q:
            n = len(q)
            end = False
            for _ in range(n):
                v = q.popleft()
                if v.left:
                    if end:
                        return False
                    q.append(v.left)
                else:
                    end = True
                if v.right:
                    if end:
                        return False
                    q.append(v.right)
                else:
                    end = True
            if q and last and last * 2 != n:
                return False
            last = n
        return True