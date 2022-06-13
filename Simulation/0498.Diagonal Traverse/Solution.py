class Solution:
    def findDiagonalOrder(self, mat: List[List[int]]) -> List[int]:
        ans = []
        m, n = len(mat), len(mat[0])
        x = y = 0
        up = True
        for _ in range(m * n):
            print("x", x , " y", y)
            ans.append(mat[x][y])
            nx, ny = x, y
            nx += -1 if up else 1
            ny += 1 if up else -1
            if nx < 0 or nx >= m or ny < 0 or ny >= n:
                nx, ny = x, y
                if up:
                    if y == n - 1:
                        nx += 1
                    else:
                        ny += 1
                else:
                    if x == m - 1:
                        ny += 1
                    else:
                        nx += 1
                up = not up
            x, y = nx, ny
        return ans