# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution:
    def distanceK(self, root: TreeNode, target: TreeNode, k: int) -> List[int]:
        edges = defaultdict(list)
        q = [root]
        while q:
            cur = q.pop()
            if cur.left:
                edges[cur.val].append(cur.left.val)
                edges[cur.left.val].append(cur.val)
                q.append(cur.left)
            if cur.right:
                edges[cur.val].append(cur.right.val)
                edges[cur.right.val].append(cur.val)
                q.append(cur.right)
        q = [target.val]
        vis = set()
        vis.add(target.val)
        ans = []
        while q:
            for _ in range(len(q)):
                cur = q.pop(0)
                if k == 0:
                    ans.append(cur)
                    continue
                for to in edges[cur]:
                    if to in vis:
                        continue
                    vis.add(to)
                    q.append(to)
            k -= 1
        return ans