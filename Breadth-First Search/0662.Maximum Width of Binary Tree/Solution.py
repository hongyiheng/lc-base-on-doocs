# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def widthOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        ans = 1
        q = deque()
        q.append(root)
        root.val = 0
        while q:
            n = len(q)
            ans = max(ans, q[-1].val - q[0].val + 1)
            for _ in range(n):
                cur = q.popleft()
                if cur.left:
                    q.append(cur.left)
                    cur.left.val = cur.val * 2 + 1
                if cur.right:
                    q.append(cur.right)
                    cur.right.val = cur.val * 2 + 2
        return ans