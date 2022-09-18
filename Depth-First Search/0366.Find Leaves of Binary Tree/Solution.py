# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findLeaves(self, root: Optional[TreeNode]) -> List[List[int]]:
        mp = defaultdict(list)

        def dfs(root):
            if not root:
                return 0
            l = dfs(root.left)
            r = dfs(root.right)
            mp[max(l, r) + 1].append(root.val)
            return max(l, r) + 1

        ans = []
        n = dfs(root)
        for i in range(1, n + 1):
            ans.append(mp[i])
        return ans