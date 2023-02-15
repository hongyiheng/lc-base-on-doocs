# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def getDirections(self, root: Optional[TreeNode], startValue: int, destValue: int) -> str:
        def dfs(root, t, s):
            if not root:
                return False
            if root.val == t:
                return True
            s.append('L')
            if dfs(root.left, t, s):
                return True
            s.pop()
            s.append('R')
            if dfs(root.right, t, s):
                return True
            s.pop()
            return False

        s_path = []
        dfs(root, startValue, s_path)
        t_path = []
        dfs(root, destValue, t_path)
        while s_path and t_path and s_path[0] == t_path[0]:
            s_path = s_path[1:]
            t_path = t_path[1:]
        return len(s_path) * 'U' + "".join(t_path)
