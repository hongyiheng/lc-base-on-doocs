# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root: TreeNode) -> str:
        """Encodes a tree to a single string.
        """
        if not root:
            return "#"
        return str(root.val) + "," + self.serialize(root.left) + "," + self.serialize(root.right)


    def deserialize(self, data: str) -> TreeNode:
        """Decodes your encoded data to tree.
        """
        def build_tree(q):
            if q and q[0] == "#":
                q.popleft()
                return None
            ans = TreeNode(int(q.popleft()))
            ans.left = build_tree(q)
            ans.right = build_tree(q)
            return ans

        q = deque()
        for v in data.split(","):
            q.append(v)
        return build_tree(q)





# Your Codec object will be instantiated and called as such:
# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# tree = ser.serialize(root)
# ans = deser.deserialize(tree)
# return ans