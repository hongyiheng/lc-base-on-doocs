# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def constructMaximumBinaryTree(self, nums: List[int]) -> Optional[TreeNode]:
        def dfs(l, r):
            if l > r:
                return None
            mx = l
            for i in range(l, r + 1):
                if nums[i] > nums[mx]:
                    mx = i
            root = TreeNode(nums[mx])
            root.left = dfs(l, mx - 1)
            root.right = dfs(mx + 1, r)
            return root

        return dfs(0, len(nums) - 1)