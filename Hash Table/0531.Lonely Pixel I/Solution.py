class Solution:
    def findLonelyPixel(self, picture: List[List[str]]) -> int:
        row, col = set(), set()
        ans = 0

        def check(x, y):
            nonlocal ans
            if x in row or y in col:
                return
            row.add(x)
            col.add(y)
            for i in range(len(picture)):
                if i == x:
                    continue
                if picture[i][y] == 'B':
                    return
            for j in range(len(picture[0])):
                if j == y:
                    continue
                if picture[x][j] == 'B':
                    return
            ans += 1

        for i in range(len(picture)):
            for j in range(len(picture[0])):
                if picture[i][j] == 'B':
                    check(i, j)
        return ans