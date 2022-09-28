# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class CBTInserter:

    def __init__(self, root: TreeNode):
        self.idx = 0
        self.tr = [root]
        cur = 0
        while cur < len(self.tr):
            node = self.tr[cur]
            if node.left:
                self.tr.append(node.left)
            if node.right:
                self.tr.append(node.right)
            cur += 1

    def insert(self, val: int) -> int:
        while self.tr[self.idx].left and self.tr[self.idx].right:
            self.idx += 1
        p, node = self.tr[self.idx], TreeNode(val)
        if not p.left:
            p.left = node
        else:
            p.right = node
        self.tr.append(node)
        return p.val

    def get_root(self) -> TreeNode:
        return self.tr[0]



# Your CBTInserter object will be instantiated and called as such:
# obj = CBTInserter(root)
# param_1 = obj.insert(val)
# param_2 = obj.get_root()
