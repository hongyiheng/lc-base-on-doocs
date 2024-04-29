class Solution:
    def diagonalSort(self, mat: List[List[int]]) -> List[List[int]]:
        def reset(i, j):
            nonlocal m, n
            q = []
            x, y = i, j
            while x < m and y < n:
                q.append(mat[x][y])
                x += 1
                y += 1
            q.sort(reverse=True)
            x, y = i, j
            while x < m and y < n:
                mat[x][y] = q.pop()
                x += 1
                y += 1

        m, n = len(mat), len(mat[0])
        for i in range(1, m):
            reset(i, 0)
        for j in range(n):
            reset(0, j)
        return mat
