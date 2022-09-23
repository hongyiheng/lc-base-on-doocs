# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def amountOfTime(self, root: Optional[TreeNode], start: int) -> int:
        mp = defaultdict(list)
        q = deque()
        vis = set()

        def dfs(parent, root):
            if not root:
                return
            if root.val == start:
                q.append(root)
                vis.add(root)
            if parent:
                mp[parent].append(root)
                mp[root].append(parent)
            dfs(root, root.left)
            dfs(root, root.right)

        dfs(None, root)
        ans = -1
        while q:
            m = len(q)
            for _ in range(m):
                cur = q.popleft()
                for v in mp[cur]:
                    if v in vis:
                        continue
                    q.append(v)
                    vis.add(v)
            ans += 1
        return ans
