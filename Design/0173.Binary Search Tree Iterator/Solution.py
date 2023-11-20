# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    def __init__(self, root: Optional[TreeNode]):
        def dfs(root):
            if not root:
                return
            dfs(root.left)
            self.q.append(root.val)
            dfs(root.right)

        self.q = []
        dfs(root)
        self.idx = 0

    def next(self) -> int:
        self.idx += 1
        return self.q[self.idx - 1]

    def hasNext(self) -> bool:
        return self.idx < len(self.q)

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()