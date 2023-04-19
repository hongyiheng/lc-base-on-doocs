# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def allPossibleFBT(self, n: int) -> List[Optional[TreeNode]]:
        ans = []
        if n % 2 == 0:
            return ans
        if n == 1:
            ans.append(TreeNode(0))
            return ans
        for i in range(1, n):
            lr = self.allPossibleFBT(i)
            rr = self.allPossibleFBT(n - i - 1)
            for l in lr:
                for r in rr:
                    root = TreeNode(0)
                    root.left = l
                    root.right = r
                    ans.append(root)
        return ans