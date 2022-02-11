# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> TreeNode:
        mp = dict()
        for i, v in enumerate(inorder):
            mp[v] = i

        def dfs(i_start, i_end, p_start, p_end):
            if i_start > i_end or p_start > p_end:
                return None
            root_val = postorder[p_end]
            root_index = mp[root_val]
            root = TreeNode(root_val)
            left_num = root_index - i_start
            root.left = dfs(i_start, root_index - 1, p_start, p_start + left_num - 1)
            root.right = dfs(root_index + 1, i_end, p_start + left_num, p_end - 1)
            return root

        return dfs(0, len(inorder) - 1, 0, len(postorder) - 1)