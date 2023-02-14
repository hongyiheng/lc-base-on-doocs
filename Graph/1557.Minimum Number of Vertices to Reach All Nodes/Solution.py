class Solution:
    def findSmallestSetOfVertices(self, n: int, edges: List[List[int]]) -> List[int]:
        vis = set()
        for _, v in edges:
            vis.add(v)
        ans = []
        for i in range(n):
            if i not in vis:
                ans.append(i)
        return ans