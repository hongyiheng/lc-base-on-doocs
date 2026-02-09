# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def balanceBST(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        def inorder(node):
            if not node:
                return
            inorder(node.left)
            nodes.append(node)
            inorder(node.right)

        def build_balanced(left, right):
            if left > right:
                return None
            mid = (left + right) // 2
            root = nodes[mid]
            root.left = build_balanced(left, mid - 1)
            root.right = build_balanced(mid + 1, right)
            return root

        nodes = []
        inorder(root)
        return build_balanced(0, len(nodes) - 1)