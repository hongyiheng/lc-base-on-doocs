# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def replaceValueInTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        root.val = 0
        q = deque([root])
        while q:
            s = 0
            for node in q:
                s += node.left.val if node.left else 0
                s += node.right.val if node.right else 0
            for _ in range(len(q)):
                cur = q.popleft()
                child_val = cur.left.val if cur.left else 0
                child_val += cur.right.val if cur.right else 0
                child_val = s - child_val
                if cur.left:
                    cur.left.val = child_val
                    q.append(cur.left)
                if cur.right:
                    cur.right.val = child_val
                    q.append(cur.right)
        return root
