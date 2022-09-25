# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def reverseOddLevels(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        q = deque()
        q.append(root)
        level = 1
        while q:
            m = len(q)
            tmp = []
            for _ in range(m):
                cur = q.popleft()
                if cur.left:
                    tmp.append(cur.left)
                if cur.right:
                    tmp.append(cur.right)
            if level % 2:
                l, r = 0, len(tmp) - 1
                while l < r:
                    tmp[l].val, tmp[r].val = tmp[r].val, tmp[l].val
                    l += 1
                    r -= 1
            q.extend(tmp)
            level += 1
        return root
