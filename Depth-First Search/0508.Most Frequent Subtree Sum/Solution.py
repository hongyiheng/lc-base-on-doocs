# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findFrequentTreeSum(self, root: TreeNode) -> List[int]:
        mp = {}
        def dfs(root):
            nonlocal mp
            if not root:
                return 0
            left = dfs(root.left)
            right = dfs(root.right)
            s = root.val + left + right
            mp[s] = mp.get(s, 0) + 1
            return s

        dfs(root)
        ans = []
        cur = 0
        for k in mp.keys():
            if mp[k] > cur:
                cur = mp[k]
                ans = [k]
            elif mp[k] == cur:
                ans.append(k)
        return ans