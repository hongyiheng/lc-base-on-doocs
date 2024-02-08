# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        q = deque([root])
        while q:
            a = b = False
            for _ in range(len(q)):
                v = q.popleft()
                if v.left:
                    if v.left.val == x and b:
                        return True
                    if v.left.val == y and a:
                        return True
                if v.right:
                    if v.right.val == x and b:
                        return True
                    if v.right.val == y and a:
                        return True
                if (v.left and v.left.val == x) or (v.right and v.right.val == x):
                    a = True
                if (v.left and v.left.val == y) or (v.right and v.right.val == y):
                    b = True
                if v.left:
                    q.append(v.left)
                if v.right:
                    q.append(v.right)
        return False