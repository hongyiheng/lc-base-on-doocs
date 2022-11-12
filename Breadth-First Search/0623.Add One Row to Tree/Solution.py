# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def addOneRow(self, root: Optional[TreeNode], val: int, depth: int) -> Optional[TreeNode]:
        if depth == 1:
            ans = TreeNode(val)
            ans.left = root
            return ans
        q = deque()
        q.append(root)
        d = 1
        while q:
            m = len(q)
            for _ in range(m):
                cur = q.popleft()
                l, r = cur.left, cur.right
                if d + 1 == depth:
                    cur.left = TreeNode(val)
                    cur.right = TreeNode(val)
                if l:
                    if d + 1 == depth:
                        cur.left.left = l
                    q.append(l)
                if r:
                    if d + 1 == depth:
                        cur.right.right = r
                    q.append(r)
            d += 1
        return root
