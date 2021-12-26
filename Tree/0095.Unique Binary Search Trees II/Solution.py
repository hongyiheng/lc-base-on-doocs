# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def generateTrees(self, n: int) -> List[TreeNode]:
        if n < 1:
            return []

        def buildTree(start, end):
            ans = []
            if start > end:
                return [None]
            for i in range(start, end + 1):
                left = buildTree(start, i - 1)
                right = buildTree(i + 1, end)
                for l in left:
                    for r in right:
                        root = TreeNode(i)
                        root.left = l
                        root.right = r
                        ans.append(root)
            return ans

        return buildTree(1, n)