class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        m, n = len(matrix), len(matrix[0])
        row, col = set(), set()
        ans = []
        x = y = d = 0
        while len(ans) < m * n:
            while x not in row and y not in col:
                ans.append(matrix[x][y])
                x += dirs[d][0]
                y += dirs[d][1]
                if x < 0 or x >= m or y < 0 or y >= n or x in row or y in col:
                    x -= dirs[d][0]
                    y -= dirs[d][1]
                    break
            if dirs[d][0] == 0:
                row.add(x)
            else:
                col.add(y)
            d = 0 if d == 3 else d + 1
            x += dirs[d][0]
            y += dirs[d][1]
        return ans

