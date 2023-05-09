# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.

        :type root: TreeNode
        :rtype: str
        """
        if not root:
            return '#'
        left = self.serialize(root.left)
        right = self.serialize(root.right)
        return str(root.val) + "," + left + "," + right

    # 1,2,#,#,3,4,#,#,5,#,#
    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        def dfs():
            val = q.pop(0)
            if val == '#':
                return None
            root = TreeNode(val)
            root.left = dfs()
            root.right = dfs()
            return root

        q = data.split(",")
        return dfs()

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))
