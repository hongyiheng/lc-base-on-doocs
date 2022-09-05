# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findDuplicateSubtrees(self, root: Optional[TreeNode]) -> List[Optional[TreeNode]]:
        mp = dict()
        ans = []

        def dfs(root):
            if not root:
                return "."
            k = str(root.val) + "," + dfs(root.left) + "," + dfs(root.right)
            cur = mp.get(k, (0, None))
            if cur[0] == 1:
                ans.append(root)
            mp[k] = (cur[0] + 1, root)
            return k

        dfs(root)
        return ans
