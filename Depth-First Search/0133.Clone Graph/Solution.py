"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        mp = dict()

        def dfs(node):
            if not node:
                return None
            ans = mp.get(node.val, Node())
            mp[node.val] = ans
            if ans.val == 0:
                ans.val = node.val
                ans.neighbors = [dfs(v) for v in node.neighbors]
            return ans

        return dfs(node)