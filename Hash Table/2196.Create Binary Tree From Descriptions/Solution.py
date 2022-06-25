# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def createBinaryTree(self, descriptions: List[List[int]]) -> Optional[TreeNode]:
        mp = dict()
        child = set()
        for d in descriptions:
            p_val, c_val = d[0], d[1]
            left = d[2] == 1
            p = mp.get(p_val, TreeNode(p_val))
            c = mp.get(c_val, TreeNode(c_val))
            if left:
                p.left = c
            else:
                p.right = c
            mp[p_val] = p
            mp[c_val] = c
            child.add(c_val)
        for v in mp.keys():
            if v not in child:
                return mp[v]
        return None