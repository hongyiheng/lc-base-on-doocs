# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        q = deque()
        q.append(root)
        ans = []
        while q:
            mx = float('-inf')
            for _ in range(len(q)):
                cur = q.popleft()
                mx = max(cur.val, mx)
                if cur.left:
                    q.append(cur.left)
                if cur.right:
                    q.append(cur.right)
            ans.append(mx)
        return ans
