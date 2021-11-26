class Solution:
    def queensAttacktheKing(self, queens: List[List[int]], king: List[int]) -> List[List[int]]:
        res = list()
        matrix = [[0 for _ in range(8)] for _ in range(8)]
        for queen in queens:
            matrix[queen[0]][queen[1]] = 1
        direct = [[1, 0], [0, 1], [-1, 0], [0, -1], [1, 1], [1, -1], [-1, 1], [-1, -1]]
        for i in range(len(direct)):
            x = king[0] + direct[i][0]
            y = king[1] + direct[i][1]
            while x >= 0 and y >= 0 and x < 8 and y < 8:
                if matrix[x][y] == 1:
                    res.append([x, y])
                    x = 100
                x += direct[i][0]
                y += direct[i][1]
        return res