# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        mp = dict()
        for i, v in enumerate(inorder):
            mp[v] = i

        def dfs(p_start, p_end, i_start, i_end):
            nonlocal preorder, inorder
            if p_start > p_end or i_start > i_end:
                return None
            root_val = preorder[p_start]
            root_index = mp[root_val]
            left_num = root_index - i_start
            root = TreeNode(root_val)
            root.left = dfs(p_start + 1, p_start + left_num, i_start, root_index - 1)
            root.right = dfs(p_start + left_num + 1, p_end, root_index + 1, i_end)
            return root

        return dfs(0, len(preorder) - 1, 0, len(inorder) - 1)