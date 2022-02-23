# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def delNodes(self, root: TreeNode, to_delete: List[int]) -> List[TreeNode]:
        del_set = set(to_delete)
        ans = []

        def dfs(root):
            nonlocal ans
            if root is None:
                return None
            root.left = dfs(root.left)
            root.right = dfs(root.right)
            if root.val in del_set:
                if root.left:
                    ans.append(root.left)
                if root.right:
                    ans.append(root.right)
                root = None
            return root

        if root.val not in del_set:
            ans.append(root)
        dfs(root)
        return ans


