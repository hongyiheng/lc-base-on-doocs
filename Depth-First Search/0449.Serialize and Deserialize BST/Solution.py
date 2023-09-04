# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root: Optional[TreeNode]) -> str:
        """Encodes a tree to a single string.
        """
        if not root:
            return '#'
        return str(root.val) + "," + self.serialize(root.left) + "," + self.serialize(root.right)




    def deserialize(self, data: str) -> Optional[TreeNode]:
        """Decodes your encoded data to tree.
        """
        def dfs(q):
            v = q.popleft()
            if v == '#':
                return None
            root = TreeNode(int(v))
            root.left = dfs(q)
            root.right = dfs(q)
            return root

        q = deque(data.split(","))
        return dfs(q)



# Your Codec object will be instantiated and called as such:
# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# tree = ser.serialize(root)
# ans = deser.deserialize(tree)
# return ans