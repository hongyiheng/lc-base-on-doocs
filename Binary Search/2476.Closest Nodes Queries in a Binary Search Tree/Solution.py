# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def closestNodes(self, root: Optional[TreeNode], queries: List[int]) -> List[List[int]]:
        def dfs(root):
            if not root:
                return
            dfs(root.left)
            q.append(root.val)
            dfs(root.right)

        def find(i, l):
            if i >= len(qs):
                return
            t, j = qs[i]
            r = len(q) - 1
            while l < r:
                mid = (l + r) >> 1
                if q[mid] >= t:
                    r = mid
                else:
                    l = mid + 1
            if q[r] >= t:
                ans[j][1] = q[r]
            if q[r] <= t:
                ans[j][0] = q[r]
            elif r > 0 and q[r - 1] <= t:
                ans[j][0] = q[r - 1]
            find(i + 1, l)

        q = []
        dfs(root)
        qs = [(v, i) for i, v in enumerate(queries)]
        qs.sort()
        ans = [[-1, -1] for _ in range(len(queries))]
        find(0, 0)
        return ans
