class Solution:
    def findChampion(self, n: int, edges: List[List[int]]) -> int:
        to = [0] * n
        for _, v in edges:
            to[v] += 1
        ans = -1
        for i, v in enumerate(to):
            if v:
                continue
            if ans != -1:
                return -1
            ans = i
        return ans