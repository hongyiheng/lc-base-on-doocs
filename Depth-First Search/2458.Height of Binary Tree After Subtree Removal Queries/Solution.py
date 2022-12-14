# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def treeQueries(self, root: Optional[TreeNode], queries: List[int]) -> List[int]:
        def get_height(node):
            if not node:
                return 0
            cur = 1 + max(get_height(node.left), get_height(node.right))
            h[node] = cur
            return cur

        def dfs(node, depth, rest_h):
            if not node:
                return
            res[node.val] = rest_h
            depth += 1
            dfs(node.left, depth, max(depth + h.get(node.right, 0), rest_h))
            dfs(node.right, depth, max(depth + h.get(node.left, 0), rest_h))

        h, res = defaultdict(int), defaultdict(int)
        get_height(root)
        dfs(root, -1, 0)
        ans = []
        for v in queries:
            ans.append(res[v])
        return ans
