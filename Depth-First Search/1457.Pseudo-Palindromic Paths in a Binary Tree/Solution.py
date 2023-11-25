# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pseudoPalindromicPaths(self, root: Optional[TreeNode]) -> int:
        def dfs(root):
            nonlocal ans
            if not root:
                return
            cnt[root.val] += 1
            if not root.left and not root.right:
                k = 0
                for v in cnt:
                    k += v % 2
                if k <= 1:
                    ans += 1
            dfs(root.left)
            dfs(root.right)
            cnt[root.val] -= 1

        ans = 0
        cnt = [0] * 10
        dfs(root)
        return ans
