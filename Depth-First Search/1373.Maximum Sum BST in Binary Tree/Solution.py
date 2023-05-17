# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxSumBST(self, root: Optional[TreeNode]) -> int:
        ans = 0
        f = dict()

        def get_sum(root):
            if root in f:
                return f[root]
            if not root:
                return 0
            l, r = get_sum(root.left), get_sum(root.right)
            f[root] = l + r + root.val
            return f[root]

        def dfs(root):
            nonlocal ans
            flag = True
            mx = mi = root.val
            if root.left:
                l_flag, l_mx, l_mi = dfs(root.left)
                flag = flag and l_flag and l_mx < root.val
                mx, mi = max(mx, l_mx), min(mi, l_mi)
            if root.right:
                r_flag, r_mx, r_mi = dfs(root.right)
                flag = flag and r_flag and root.val < r_mi
                mx, mi = max(mx, r_mx), min(mi, r_mi)
            if flag:
                ans = max(ans, get_sum(root))
            return (flag, mx, mi)

        dfs(root)
        return ans
