# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalTraversal(self, root: TreeNode) -> List[List[int]]:
        M, N = 1010, 2010
        g = [[None] * N for _ in range(M)]
        q = deque()
        q.append((0, 1000, root))
        while q:
            m = len(q)
            for _ in range(m):
                cur = q.popleft()
                x, y, node = cur[0], cur[1], cur[2]
                if not g[x][y]:
                    g[x][y] = []
                heapq.heappush(g[x][y], node.val)
                if node.left:
                    q.append((x + 1, y - 1, node.left))
                if node.right:
                    q.append((x + 1, y + 1, node.right))
        ans = []
        for j in range(N):
            col = []
            for i in range(M):
                while g[i][j]:
                    col.append(heapq.heappop(g[i][j]))
            if col:
                ans.append(col)
        return ans