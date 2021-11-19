class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        m, n = len(matrix), len(matrix[0])
        p = list()
        for i in range(m):
            for j in range(n):
                p.append(matrix[i][j])
        list.sort(p)
        return p[k - 1]